package lecture22;

import lecture11.MapUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadPool {
    private static List<String> words;
    private static final HashMap<String, Integer> wordFull = new HashMap<>();
    static String[] arrArticles = {"the", "and", "to", "of", "a", "he", "in", "that", "his", "was", "with", "it", "had",
            "her", "not", "him", "at", "i", "s", "but", "as", "on", "you", "for", "she", "is", "from", "be", "by",
            "were", "what", "they", "who", "this", "which", "so", "an", "up", "there", "them", "or", "when", "did",
            "been", "their", "no", "would", "now", "only", "than", "he", "s", "g", "'s", "your",
            "if", "me", "are", "my", "could", "t", "we", "will", "about", "how", "then", "into", "himself"};

    public static boolean containArticles(String s) {


        for (String strArr :
                arrArticles) {
            if (strArr.equals(s))
                return true;
        }
        return false;
    }

    public static List<String> getWords(List<String> lines, boolean withArticles) {
        List<String> words = new ArrayList<>();
        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0) {
                    if (!withArticles)
                        if (containArticles(s.trim()))
                            continue;
                    words.add(s.trim());
                }
            }
        }
        return words;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        File text = new File("D:\\Программирование\\workspace\\Study\\ITMO-task\\lecture11\\wp.txt");
        long time = System.currentTimeMillis();
        List<String> lines = Files.readAllLines(text.toPath());
        words = getWords(lines, false);
        int cpus = Runtime.getRuntime().availableProcessors();
        int len = words.size() / cpus;
        ExecutorService pool = Executors.newFixedThreadPool(cpus);
        List<Future<Map<String, Integer>>> futs = new ArrayList<>(20);
        for (int i = 0; i < cpus; i++) {
            final int ii = i;
            Future<Map<String, Integer>> fut = pool.submit(new Callable<Map<String, Integer>>() {
                @Override
                public Map<String, Integer> call() throws Exception {
                    HashMap<String, Integer> wordPart = new HashMap<>();
                    for (String s : words.subList(len * ii, len * (ii + 1))) {
                        if (s.length() > 0) {
                            if (containArticles(s.trim()))
                                continue;
                            int num = 1;
                            if (wordPart.containsKey(s)) {
                                num = wordPart.get(s) + 1;
                            }
                            wordPart.put(s, num);
                        }
                    }

                    return wordPart;
                }
            });
            futs.add(fut);
        }
        for (Future<Map<String, Integer>> fut : futs
                ) {

            for (Map.Entry<String, Integer> entry : fut.get().entrySet()
                    ) {
                int num = entry.getValue();
                if (wordFull.containsKey(entry.getKey())) {
                    num += wordFull.get(entry.getKey()) ;
                }
                wordFull.put(entry.getKey(), num);

            }
        }
        pool.shutdown();

        MapUtil.printlnCount(MapUtil.sortByComparator(wordFull, false), 10);
        System.out.println(System.currentTimeMillis() - time);

    }
}

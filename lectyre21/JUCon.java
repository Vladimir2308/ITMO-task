package lectyre21;

import lecture11.MapUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class JUCon {


    private static final BlockingDeque<String> lineQueue = new LinkedBlockingDeque<>();
    private static final ConcurrentHashMap<String, Integer> wordQueue = new ConcurrentHashMap<>();
    final static String STOP = "";

    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("D:\\Программирование\\workspace\\Study\\ITMO-task\\lecture11\\wp.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());
        for (String line :
                lines) {
            try {
                lineQueue.put(line);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(lineQueue.size());
        try {
            lineQueue.put(STOP);
            lineQueue.put(STOP);
            lineQueue.put(STOP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(new Thr(wordQueue, lineQueue));
        Thread t2 = new Thread(new Thr(wordQueue, lineQueue));
        Thread t3 = new Thread(new Thr(wordQueue, lineQueue));
        long time = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(wordQueue.size());
        MapUtil.printlnCount(MapUtil.sortByComparator(wordQueue, false), 10);
        System.out.println(System.currentTimeMillis() - time);
    }

}

class Thr implements Runnable {
    ConcurrentHashMap<String, Integer> wordQueue;
    BlockingDeque<String> lineQueue;

    Thr(ConcurrentHashMap<String, Integer> wordQueue, BlockingDeque<String> lineQueue) {
        this.wordQueue = wordQueue;
        this.lineQueue = lineQueue;
    }

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

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");

        String line = "";
        while (!Thread.currentThread().isInterrupted()) {
            if (lineQueue.size() > 0) {
                try {
                    line = lineQueue.take();

                    String[] wordSplit =
                            line.toLowerCase() // Переводим в нижний регистр
                                    .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                                    .trim() // Убираем пробелы в начале и конце строки.
                                    .split("\\s"); // Разбиваем строки на слова

                    for (String s : wordSplit) {
                        // Выбираем только непустые слова.
                        if (s.length() > 0) {
                            if (containArticles(s.trim()))
                                continue;
                            int num = 1;
                            if (wordQueue.containsKey(s)) {
                                num = wordQueue.get(s) + 1;
                            }
                            wordQueue.put(s, num);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            } else Thread.currentThread().interrupt();
//            if (lineQueue.size() == 0) {
//                                Thread.currentThread().interrupt();
//                System.out.println(" Thread interrupt: " + Thread.currentThread().getName());
//            }
        }
    }
}
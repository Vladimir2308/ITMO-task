package lecture20;

import lecture11.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WCExample {
    static Map<String, Integer> mainMap;
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


    public static class ThreadForWords extends Thread {

        List<String> wordsPart;
        Map<String, Integer> map;

        public ThreadForWords(List<String> wordsPart) {
            this.wordsPart = wordsPart;
            map = new HashMap<>();
        }

        public Map<String, Integer> getMap() {
            return map;
        }

        @Override
        public void run() {
            System.out.println(" Started: " + Thread.currentThread().getName());
            for (String str :
                    wordsPart) {
                int i;
                if (map.containsKey(str))
                    i = map.get(str) + 1;
                else i = 1;
                map.put(str, i);
            }
            System.out.println("map: " + map.size());
            addMapToMainMap(map);
            System.out.println(" End: " + Thread.currentThread().getName());
        }

        private static void addMapToMainMap(Map<String, Integer> map) {
            synchronized (WCExample.class) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    int i;
                    if (mainMap.containsKey(entry.getKey()))
                        i = mainMap.get(entry.getKey()) + entry.getValue();
                    else i = entry.getValue();
                    mainMap.put(entry.getKey(), i);

                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("D:\\Программирование\\workspace\\Study\\ITMO-task\\lecture11\\wp.txt");
        // Вычитываем все строки из файла
        long time = System.currentTimeMillis();
        List<String> lines = Files.readAllLines(text.toPath());
        mainMap = new HashMap<>();
        List<String> words = getWords(lines, false);
        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors: " + cpu);
        if (cpu < 4) cpu = 4;
        int len = words.size() / 4;
        System.out.println("len " + len);
        List<Thread> listThread = new ArrayList<>();
        for (int i = 0; i < cpu; i++) {
            ThreadForWords thread = new ThreadForWords(words.subList(len * i, len * (i + 1)));

            thread.setName("T-" + i);
            thread.start();
            System.out.println(thread.getName() + " " + thread.getThreadGroup());
            listThread.add(thread);

        }
        System.out.println(" main: " + Thread.currentThread().getThreadGroup());
        for (Thread t :
                listThread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            HashMap<String, Integer> wordsSortedWithoutArticl = (HashMap) MapUtil.sortByComparator(mainMap, false);
        System.out.println("Top 10 words without articles");
        MapUtil.printlnCount(wordsSortedWithoutArticl, 10);
        System.out.println(System.currentTimeMillis() - time);
    }
}
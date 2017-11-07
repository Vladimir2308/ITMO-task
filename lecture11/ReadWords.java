package lecture11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("out\\production\\Study\\lecture11\\wp.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
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
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }
        List<String> sentences = new ArrayList<>();
        String temp = "";
        for (String line : lines) {
            // Для каждой строки
            line = temp + line.toLowerCase();

            while (line.length() > 0) {

                Pattern p = Pattern.compile("(\\w+\\s\\w+)");
                Matcher m = p.matcher(line);
                if (m.find()) {
                    temp = m.group();
                    if (temp.length() > 0)
                        sentences.add(temp.trim());
                    line = line.substring(m.start());
                    line = line.replaceFirst("(\\w+\\s)", "");
                    temp = "";
                } else {
                    temp = line;
                    line = "";
                }
            }

        }

//        for (String word : words) {
//            System.out.println(word);
//        }
//        for (String word : sentences) {
//            System.out.println(word);
//        }
        HashMap<String, Integer> wordsUnsorted = new HashMap<>();
        for (String word : words) {
            int i;
            if (wordsUnsorted.containsKey(word))
                i = wordsUnsorted.get(word) + 1;
            else i = 1;
            wordsUnsorted.put(word, i);
        }
        HashMap<String, Integer> sentencesUnsorted = new HashMap<>();
        for (String sentence : sentences) {
            int i;
            if (wordsUnsorted.containsKey(sentence))
                i = wordsUnsorted.get(sentence) + 1;
            else i = 1;
            wordsUnsorted.put(sentence, i);
        }
        HashMap<String, Integer> wordsSorted = (HashMap) MapUtil.sortByComparator(wordsUnsorted, new Boolean(true));
//        MapUtil.println(wordsSorted);
        int countwords = wordsSorted.size();
        int numberChar = -1;
        ArrayList<Map> arr = new ArrayList<>(10);

        while (countwords > 0) {
            ++numberChar;
            Map<String, Integer> sortedMapChar = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : wordsSorted.entrySet()) {
                if (entry.getKey().length() == numberChar) {
                    sortedMapChar.put(entry.getKey(), entry.getValue());
                    countwords--;
                }
            }
            arr.add(sortedMapChar);
        }
        System.out.println("Выведем группу из 16 слов: ");
        MapUtil.println(arr.get(16));

    }

}

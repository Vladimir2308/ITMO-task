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

    public static String replaseArticles(String s) {


        for (String strArr :
                arrArticles) {
            String temp = " " + strArr + " ";
            s = " " + s + " ";
            if (s.contains(temp))
                s = s.replaceAll(strArr, " . ");
        }
        return s;
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

    public static HashMap<String, Integer> getWordsUnsotred(List<String> lines, boolean withArticles) {
        HashMap<String, Integer> wordsUnsorted = new HashMap<>();
        List<String> words = getWords(lines, withArticles);
        for (String word : words) {
            int i;
            if (wordsUnsorted.containsKey(word))
                i = wordsUnsorted.get(word) + 1;
            else i = 1;
            wordsUnsorted.put(word, i);
        }
        return wordsUnsorted;
    }

    public static HashMap<String, Integer> getSentences(List<String> lines, boolean withArticles) {
        List<String> sentences = new ArrayList<>();
        String temp = "";
        for (String line : lines) {
            line = temp + " " + line.toLowerCase().trim();
            if (!withArticles) {
                line = replaseArticles(line);
            }

            while (line.length() > 0) {

                Pattern p = Pattern.compile("(\\w+\\s+\\w+)");
                Matcher m = p.matcher(line);
                if (m.find()) {
                    temp = m.group();
                    if (temp.length() > 0) {
                        sentences.add(temp.trim());
                    }
                    line = line.substring(m.start());
                    line = line.replaceFirst("(\\w+\\s+)", "");
                    temp = "";
                } else {
                    temp = line;
                    line = "";
                }
            }

        }


        HashMap<String, Integer> sentencesUnsorted = new HashMap<>();
        for (String sentence : sentences) {
            int i;
            if (sentencesUnsorted.containsKey(sentence))
                i = sentencesUnsorted.get(sentence) + 1;
            else i = 1;
            sentencesUnsorted.put(sentence, i);
        }

        return sentencesUnsorted;
    }

    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("out\\production\\Study\\lecture11\\wp.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        HashMap<String, Integer> wordsUnsorted = getWordsUnsotred(lines, true);
        HashMap<String, Integer> wordsSorted = (HashMap) MapUtil.sortByComparator(wordsUnsorted, false);
        System.out.println("Top 10 words with articles");
        MapUtil.printlnCount(wordsSorted, 10);
//        MapUtil.println(wordsSorted);

        HashMap<String, Integer> wordsUnsortedWithoutArticl = getWordsUnsotred(lines, false);
        HashMap<String, Integer> wordsSortedWithoutArticl = (HashMap) MapUtil.sortByComparator(wordsUnsortedWithoutArticl, false);
        System.out.println("Top 10 words without articles");
        MapUtil.printlnCount(wordsSortedWithoutArticl, 10);
//        MapUtil.println(wordsSortedWithoutArticl);
//       --------- sentences --------------------------------------------------------------------


        HashMap<String, Integer> sentencesUnsorted = getSentences(lines, true);
        HashMap<String, Integer> sentencesSorted = (HashMap) MapUtil.sortByComparator(sentencesUnsorted, false);
//        MapUtil.println(sentencesSorted);
        System.out.println("Top 10 sentences with articles");
        MapUtil.printlnCount(sentencesSorted, 10);

        HashMap<String, Integer> sentencesUnsortedWithoutArticl = getSentences(lines, false);
        HashMap<String, Integer> sentencesSortedWithoutArticl = (HashMap) MapUtil.sortByComparator(sentencesUnsortedWithoutArticl, false);
//        MapUtil.println(sentencesSortedWithoutArticl);
        System.out.println("Top 10 sentences without articles");
        MapUtil.printlnCount(sentencesSortedWithoutArticl, 10);

//        -------------- words to groups -------------------------------------------------------------

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
//        System.out.println("Выведем группу из 10 слов: ");
//        MapUtil.println(arr.get(10));
//        -------------- characters -------------------------------------------------------------
        HashMap<Character, Integer> characters = new HashMap<>();
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            characters.put((char) i, 0);
        }
        List<String> words = getWords(lines, true);
        int count=0;
        for (String word : words) {
            char[] strToArray = word.toCharArray();
            for (int i = 0; i < strToArray.length; i++) {
                if ((int)strToArray[i] >= (int) 'a' && strToArray[i] <= (int) 'z') {
                    int z = characters.get(strToArray[i]) + 1;
                    characters.put(strToArray[i], z);
                    count++;
                }
            }
        }
        double [] procent=new double [(int)'z'+1];
        System.out.println(count);
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            procent[i]=((double)characters.get((char)i))*100/count;
        }
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            System.out.println("\""+(char) i+ "\" - "+ characters.get((char)i)+ " - "+ procent[i]+ " % ");
        }
    }
}

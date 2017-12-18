package lecture24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class WPStream {
    public static void main(String[] args) {


        Path path = Paths.get("D:\\Программирование\\workspace\\Study\\ITMO-task\\lecture11\\wp.txt");
        Map<String, Long> result = null;
        try {
            result = Files.lines(path)
                    .parallel()
                    .map(line -> line.toLowerCase().replaceAll("\\pP", " "))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(String::trim)
                    .filter(word -> word.length() == 10)
                    .collect(groupingBy(identity(), counting()))

                    .entrySet().parallelStream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .limit(10)
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
package lecture11;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = " Mother washing rames, to the before washing cars.";
        int i = 0;
        String[] arr = new String[100];
        while (str.length() > 0) {
            String temp = "";

            str = temp + " " + str.toLowerCase().trim();
            Pattern p = Pattern.compile("(\\w+\\s+\\w+)");
            Matcher m = p.matcher(str);
            if (m.find()) {
                temp = m.group();
                if (temp.length() > 0)
                    arr[i++] = temp.trim();
                str = str.substring(m.start());
                str = str.replaceFirst("(\\w+\\s+)", "");
                temp = "";
            } else {
                temp = str;
                str = "";
            }
        }


        System.out.println(" : " + Arrays.toString(arr));
        System.out.println((int)'a');
        System.out.println((int)'z');
    }

}


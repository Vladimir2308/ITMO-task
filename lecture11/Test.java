package lecture11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str= " Mother washing rames, before washing cars.";
//        while (str.length()>0) {
            int i=0;
            String [] frazeSplit= new String[2000000];
            Pattern p = Pattern.compile("(\\w+\\s\\w+)");

            Matcher m = p.matcher(str);
        while(m.find()){
                System.out.println(" : " + m.group());
            }

//        }
    }
}

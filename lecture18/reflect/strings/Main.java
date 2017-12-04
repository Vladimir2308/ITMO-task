package lecture18.reflect.strings;

import lecture17.Senser;

public class Main {
    public static void main(String[] args) {
        Senser senser=new Senser ();

        try {
            System.out.println(Utils.toString(senser));
        } catch (IllegalAccessException e) {

        }
    }
}

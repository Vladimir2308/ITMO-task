package Lecture3;


import java.util.Random;

public class Crypt {
     private static  byte[] key ;
    static String strAllowedCharacters =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static byte[] encode(String text) {
        byte[] txt = text.getBytes();
        key = new byte[text.length()];
        byte[] res = new byte[text.length()];

        key=getNextRandomString(strAllowedCharacters,text.length()).getBytes();
        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }

        return res;
    }
    public static String decode(byte[] pText) {
        byte[] res = new byte[pText.length];

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return new String(res);
    }
    private static String getNextRandomString(String strAllowedCharacters,int size) {

        StringBuilder sbRandomString = new StringBuilder(size);

        for(int i = 0 ; i < size; i++){

            //get random integer between 0 and string length
            Random random= new Random();
            int randomInt = random.nextInt(strAllowedCharacters.length());

            //get char from randomInt index from string and append in StringBuilder
            sbRandomString.append( strAllowedCharacters.charAt(randomInt) );
        }
        return sbRandomString.toString();
    }


    public static void main(String[] args) {
        byte[] arr=encode("Hello world");
        String str=new String(arr);
        System.out.println(str);
        String newstr= decode (arr);
        System.out.println(newstr);
        System.out.println(new String(key));


    }
}

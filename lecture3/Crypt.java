package lecture3;

import java.security.SecureRandom;

public class Crypt {
    private static byte[] key;

    private static byte[] encode(String text) {
        byte[] txt = text.getBytes();
        key = new byte[text.length()];
        byte[] res = new byte[text.length()];
        key = getNextRandomString(text.length());
        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }
        return res;
    }

    private static String decode(byte[] pText) {
        byte[] res = new byte[pText.length];
        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }
        return new String(res);
    }

    private static byte[] getNextRandomString(int size) {
        SecureRandom rnd = new SecureRandom();
        byte[] token = new byte[size];
        rnd.nextBytes(token);
        return token;
    }


    public static void main(String[] args) {
        String str1 = "Hello world";
        System.out.println(" String: " + str1);
        byte[] arr = encode(str1);
        String str = new String(arr);
        System.out.println("key:" + new String(key));
        System.out.println(" String code  " + str);
        String newstr = decode(arr);
        System.out.println(" decode String " + newstr);
    }
}

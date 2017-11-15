package lecture14;

import java.io.*;
import java.security.SecureRandom;

public class CryptFile {

    private static int bufferLength = 1024;
    private static byte[] key = getNextRandomString(bufferLength);


    private static void encode(File source, File dest) throws IOException {
        FileInputStream ins;
        FileOutputStream outs;


        ins = new FileInputStream(source);
        outs = new FileOutputStream(dest);
        byte[] buffer = new byte[bufferLength];
        int length;

        while ((length = ins.read(buffer)) > 0) {
            byte[] res = new byte[length];

            for (int i = 0; i < length; i++) {
                res[i] = (byte) (buffer[i] ^ key[i]);
            }
            outs.write(res, 0, length);
        }
        ins.close();
        outs.flush();
        outs.close();
    }


    private static byte[] getNextRandomString(int size) {
        SecureRandom rnd = new SecureRandom();
        byte[] token = new byte[size];
        rnd.nextBytes(token);
        return token;
    }


    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\download\\новая папка\\1.txt");
        File file2 = new File("D:\\download\\новая папка\\1code.txt");
        File file3 = new File("D:\\download\\новая папка\\1decode.txt");


        encode(file1, file2);
        encode(file2, file3);
    }
}

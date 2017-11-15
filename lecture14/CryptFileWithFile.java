package lecture14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CryptFileWithFile {


    private static void encode(File source, File dest, File crypt) throws IOException {
        FileInputStream ins;
        FileOutputStream outs;
        FileInputStream insCrypt;

        byte[] key;
        ins = new FileInputStream(source);
        insCrypt = new FileInputStream(crypt);
        byte[] buffer1 = new byte[(int) (crypt.length())];
        insCrypt.read(buffer1);
        key =  buffer1.clone();

        outs = new FileOutputStream(dest);
        int bufferLength = 1024;
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


    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\download\\новая папка\\1.txt");
        File file2 = new File("D:\\download\\новая папка\\2code.txt");
        File crypt = new File("D:\\download\\новая папка\\key.txt");
        File file3 = new File("D:\\download\\новая папка\\2decode.txt");


        encode(file1, file2,crypt);
        encode(file2, file3,crypt);
    }
}

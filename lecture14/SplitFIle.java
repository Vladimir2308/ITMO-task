package lecture14;

import java.io.*;

public class SplitFIle {

    private static void splitFile(File source, File dest, int size) throws IOException {
        String path = dest.getPath();
        int parts= (int)Math.round(source.length()/size+0.5);
        OutputStream[] array=new OutputStream[parts];
        for (int i = 0; i < parts; i++) {
            dest = new File(path.substring(0, path.lastIndexOf('.')) + "(" +
                    i + ")" + path.substring(path.lastIndexOf('.')));
            array[i]=new FileOutputStream(dest);
        }
        try (FileInputStream ins = new FileInputStream(source)) {
            int sizeBuff=1024;
            while (sizeBuff>size){
                sizeBuff/=2;
            }
            byte[] buffer = new byte[sizeBuff];
            int length;
            int writed = 0;
            int i = 0;

            while ((length = ins.read(buffer)) > 0) {


                if (length <= size - writed) {
                    array[i].write(buffer, 0, length);
                    writed += length;
                } else {

                    array[i++].write(buffer, 0, size - writed);
                    array[i].write(buffer,size - writed,length-size + writed);
                    writed = length-size + writed;


                }
            }
            for (OutputStream stream:array
                 ) {
                stream.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\download\\новая папка\\1.txt");
        File file2 = new File("D:\\download\\новая папка\\1splited.txt");
        splitFile(file1, file2, 1024);
    }
}

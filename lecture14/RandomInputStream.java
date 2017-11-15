package lecture14;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RandomInputStream extends InputStream {

    private long timeBegin;
    private long time;

    private RandomInputStream(int timeSec) {

        timeBegin = System.currentTimeMillis();
        time = timeSec * 1000;
        System.out.println(System.currentTimeMillis());

    }


    @Override
    public int read() throws IOException {
        if (System.currentTimeMillis() > timeBegin + time) {

            System.out.println("read time " + (System.currentTimeMillis()-timeBegin));
            return -1;
        }

        byte[] b = new byte[1];
        new Random().nextBytes(b);

        return b[0]& 0xff;

    }


    public int available() {
        if (System.currentTimeMillis() > timeBegin + time) {
            System.out.println("avail time  " + (System.currentTimeMillis()-timeBegin));

            return -1;
        }
        return 1024;
    }

    public static void main(String[] args) throws IOException {
        try (InputStream stream = new RandomInputStream(10)) {

            byte[] buffer = new byte[1024];
            while (stream.read(buffer) > 0) {
                for (byte b:buffer
                     ) {
                    System.out.println(Integer.toBinaryString(b & 0xff));
                }
            }
        }
    }
}

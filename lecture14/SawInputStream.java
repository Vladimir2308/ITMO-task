package lecture14;

import java.io.IOException;
import java.util.Arrays;

public class SawInputStream implements AutoCloseable {
    private int num = 0;

    private long timeBegin;
    private long time;
    private static SawInputStream saw;

    private SawInputStream(int timeSec) {

        timeBegin = System.currentTimeMillis();
        time = timeSec * 1000;
        System.out.println(System.currentTimeMillis());
        saw = this;
    }


    private int[] read() throws IOException {
        if (System.currentTimeMillis() > timeBegin + time) {

            System.out.println("read time " + (System.currentTimeMillis() - timeBegin));
            return null;
        }
        if (num > 15) num = 0;
        num++;
        int[] b = new int[num];
        for (int j = 0; j < num; j++) {
            b[j] = (int) (Math.random() * 10);
        }
        return b;
    }


    private int available() {
        if (System.currentTimeMillis() > timeBegin + time) {
            System.out.println("avail time  " + (System.currentTimeMillis() - timeBegin));
            return -1;
        }
        return 1024;
    }

    public static void main(String[] args) throws Exception {
        try (SawInputStream stream = new SawInputStream(10)) {
            int[] array;
            while (stream.available() > 0) {
                array = stream.read();
                System.out.println(Arrays.toString(array));
            }
        }
    }

    @Override
    public void close() throws Exception {
        saw.close();
    }
}


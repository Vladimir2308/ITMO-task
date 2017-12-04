package lecture18.reflect.example;

import java.util.Random;

public class Singleton {
    private int ver = new Random().nextInt();

    @Override
    public String toString() {
        return "Singleton{" +
                "ver=" + ver +
                '}';
    }
}

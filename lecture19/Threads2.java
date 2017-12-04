package lecture19;

public class Threads2 implements Runnable {

    @Override
    public void run() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Threads2 t= new Threads2();
        t.run();
    }
}

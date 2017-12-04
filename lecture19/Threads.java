package lecture19;

public class Threads extends Thread {


    public static void main(String[] args) {


        Threads t = new Threads();
        t.start();
        System.out.println(t.isInterrupted());
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
        System.out.println(t.getContextClassLoader());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}

package lecture20;

public class Customer extends Thread {
    public boolean ready = true;
    public static String str = "Kartoshechka";
    String answer;
    Waiter waiter;
    public boolean mealsReady;

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
        waiter.setCustomer(this);
    }


    @Override
    public void run() {
        boolean first = true;
        while (!isInterrupted()) {

            synchronized (str) {
                try {
                    if (first) {

                        System.out.println("run1"+ this);
                        first = false;
                    } else {
                        str.wait();
                    }
                    if (ready) {
                        ready = false;
                        if (waiter == null) {
                            System.out.println("Call waiter, please");
                            continue;
                        }
                        waiter.ready = true;

                        waiter.setStr(str);
                        str.notifyAll();
                    }
                    if (mealsReady) {
                        System.out.println("Customer: " +answer);
                    }
                } catch (InterruptedException e) {
                    interrupt();
                }
            }
        }

    }

    public void setStr(String str) {

        answer=str;
    }
}

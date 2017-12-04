package lecture20;

public class Cooker extends Thread {
    public boolean ready;
    String str;
    Waiter waiter;

    void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (Customer.str) {
                try {
                    System.out.println("run "+ currentThread().getName()+ "  before wait");
                    Customer.str.wait();
                    System.out.println("run "+ currentThread().getName()+ "  after wait");
                    System.out.println("ready "+ ready);
                    if (ready) {

                        ready = false;
                        if (waiter == null) {
                            System.out.println("Where is that waiter?");
                            continue;
                        }

                        waiter.mealsReady = true;
                        System.out.println("set waiter.mealsReady");
                        waiter.setNewStr(str + " jarenaya");
                        Customer.str.notifyAll();


                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

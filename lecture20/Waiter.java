package lecture20;

public class Waiter extends Thread {
    public volatile boolean ready;
    public volatile boolean mealsReady;
    Cooker cook;
    Customer cust;
    static String str;
    String newStr;

    public void setStr(String str) {
        this.str = str;
    }

    void setCooker(Cooker cook) {
        this.cook = cook;
        cook.setWaiter(this);
    }

    void setCustomer(Customer cust) {
        this.cust = cust;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (Customer.str) {
                try {
                    System.out.println("run "+ currentThread().getName()+ "  before wait");
                    Customer.str.wait();
                    System.out.println("run "+ currentThread().getName()+ "  after wait");
                    if (ready) {

                        ready = false;
                        if (cook == null) {
                            System.out.println("Where is that cook?");
                            continue;
                        }
                        System.out.println("run"+ this);
                        System.out.println("cook.ready "+ cook.ready);
                        cook.ready = true;
                        System.out.println("cook.ready "+ cook.ready);
                        cook.setStr(str);
                        Customer.str.notifyAll();

                    }
                    System.out.println("mealsReady "+ mealsReady);
                    if (mealsReady) {

                        mealsReady = false;
                        if (cust == null) {
                            System.out.println("Where is customer?");
                            continue;
                        }

                        cust.mealsReady = true;
                        cust.setStr(newStr);
                        System.out.println("run "+ currentThread().getName()+ "  after before cust");
                        Customer.str.notifyAll();

                    }
                } catch (InterruptedException e) {
                    interrupt();
                }
            }

        }
    }

    public void setNewStr(String s) {
        newStr = s;
    }
}

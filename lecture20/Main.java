package lecture20;

public class Main {
    public static void main(String[] args) {

        System.out.println("there");
        Customer cust = new Customer();
        Waiter waiter = new Waiter();
        Cooker cook = new Cooker();
        cust.setWaiter(waiter);
        waiter.setCooker(cook);
        cust.setName("cust");
        waiter.setName("waiter");
        cook.setName("cook");

        waiter.start();
        cook.start();

        cust.start();



    }
}
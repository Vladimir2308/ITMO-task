package lecture12;

import java.util.List;

public class Transaction {
    private List<Product> cart;
    private int total;
    private User user;
    private long time;
    private int id;
    private static int number=0;


    Transaction(List<Product> cart, int total, User user, long time) {
        this.cart = cart;
        this.total = total;
        this.user = user;
        this.time = time;
        id=++number;
    }
   public String toString(){
       return " Number: "+ id+ " total: "+  total + " user: " + user.getLogin();

    }
}

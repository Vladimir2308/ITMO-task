package lecture12;

import java.util.ArrayList;
import java.util.List;

public class User {
    static int count=0;
    private String login;
    private String password;
    List<Product> cart;
    private int id;

    User(String str){
      login =str;
        cart = new ArrayList<>();
    }

    String getPass() {
        return password;
    }
    String getLogin() {
        return login;
    }

    void setPass(String password) {
        this.password = password;
    }

    void setId(int id) {
        this.id = count++;
    }

    void put(Product p) {
        cart.add(p);
    }

    public Product get(int id) {
        for (Product p :
                cart) {
            if (p.id==id)
                return p;

        }
        return null;
    }
    public void print() {
        if (cart.size()==0) System.out.println("Cart is empty");
        for (Product p :
                cart) {
            System.out.println("Products im cart: "+p.title+ " count: " + p.quantity);

        }
    }
}

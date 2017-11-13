package lecture12;

public class Product {
    int id;
    String title;
    String description;
    int quantity;
    int price;


    Product(int id,String title, String description, int quantity, int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
    void changeQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return title;
    }
    public int getId() {
        return id;
    }
}

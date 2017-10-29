package Lecture7.Task6LibriaryHash;

public class Task6Library {
    public static void main(String[] args) {
        Library lib = new Library();
        Book book1 = new Book("Pushkin A.S.", "Captain's daughter", 155);
        Book book2 = new Book("Tolstoi L.N.", "War and peace", 504);
        Book book3 = new Book("Yosya", "War ", 5);
        Book book4 = new Book("Huan", "Peace", 4);
        Book book5 = new Book("Tom", "Jerry", 324);
        Book book6 = new Book("Jack", "Jack", 504);
        Book book7 = new Book("Jack", "Book", 504);
        Book book8 = new Book("John", "Jack", 504);
        lib.put(book1, 5);

        lib.put(book1,
                10);

        lib.get(book1, 2);
        lib.put(book2, 10);
        lib.put(book2, 10);
        lib.put(book3, 11);
        lib.put(book4, 12);
        lib.put(book5, 13);
        lib.put(book6, 14);
        lib.put(book7, 130);
        lib.put(book8, 140);
        lib.get(book8, 29);

        System.out.println("book1 " + lib.getQuantity(book1));
        System.out.println("book2 " + lib.getQuantity(book2));
        System.out.println("book3 " + lib.getQuantity(book3));
        System.out.println("book4 " + lib.getQuantity(book4));
        System.out.println("book5 " + lib.getQuantity(book5));
        System.out.println("book6 " + lib.getQuantity(book6));
        System.out.println("book7 " + lib.getQuantity(book7));
        System.out.println("book8 " + lib.getQuantity(book8));
    }

}

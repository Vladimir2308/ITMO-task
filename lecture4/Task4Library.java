package lecture4;

public class Task4Library {
    public static void main(String[] args) {
        Library lib= new Library();
        Book book1= new Book("Pushkin A.S.","Captain's daughter", 155);
        Book book2= new Book("Tolstoi L.N.","War and peace", 504);
        lib.put( book1,5 );
        System.out.println(lib.getQuantity( book1) );
        lib.put( book1,10 );
        System.out.println(lib.getQuantity( book1) );
        System.out.println(lib.get( book1,2) );
        lib.put( book2,10 );
        lib.put( book2,10 );
        System.out.println(lib.getQuantity( book1) );
        System.out.println(lib.getQuantity( book2) );
    }

}

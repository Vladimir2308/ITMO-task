public class Example{
    static boolean created=false;

public Example(){
    if (created) return;
    created=true;
    System.out.println("Object created");
}
    public static void main(String[] args) {
        new Example();
        new Example();
        new Example();
    }
}

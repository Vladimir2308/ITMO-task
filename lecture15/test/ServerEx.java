package lecture15.test;

public class ServerEx extends Server {
    static int x=22;
    static void sum(){
        System.out.println(x);
    }
    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(Server.x);
        Server.sum();
        System.out.println(y);
    }
}

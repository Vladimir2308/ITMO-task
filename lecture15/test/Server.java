package lecture15.test;

import java.io.IOException;

public class Server {
    static int x=1;
    static int y=9;
    static void sum(){
        System.out.println(x);
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int i =0;
        System.out.println(int.class);
//               ServerSocket ssock=new ServerSocket(12345);
//        while (true) {
//            Socket sock = ssock.accept();
//            InputStream in= sock.getInputStream();
//            OutputStream out=sock.getOutputStream();
//            ObjectInputStream inObj=new ObjectInputStream(in);
//            ObjectOutputStream outObj= new ObjectOutputStream(out);
//            outObj.writeObject("Hello");
//            Object read=  inObj.readObject();
//            System.out.println(read);
//        }

    }
}

package lecture15.test;

import lecture15.Command;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket sock= new Socket();
        sock.connect(new InetSocketAddress("localhost",12345));
        InputStream in= sock.getInputStream();
        OutputStream out= sock.getOutputStream();
        ObjectOutputStream outObj= new ObjectOutputStream(out);
        ObjectInputStream inObj=new ObjectInputStream(in);
        String read= (String) inObj.readObject();
        System.out.println(read);
        outObj.writeObject(new Command("zzzz"));
        out.flush();
    }
}

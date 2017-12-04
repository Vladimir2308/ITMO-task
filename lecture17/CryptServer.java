package lecture17;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CryptServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
int port=12345;
        ServerSocket ssocket=new ServerSocket(port);

        Socket socket = ssocket.accept();
        try (
                ObjectOutputStream objOut= new ObjectOutputStream(new CryptOutPutStream(socket.getOutputStream()));
//                ObjectOutputStream objOut= new ObjectOutputStream(new com.itmo.patterns.CryptoOutputStream(socket.getOutputStream(),"Hello".getBytes()));
        ){
            objOut.writeObject("qwerty");
            objOut.flush();
        }




    }
}












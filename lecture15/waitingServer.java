package lecture15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class waitingServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ssock = new ServerSocket(12345);
        while (true) {
            Socket sock = ssock.accept();
            InputStream is = sock.getInputStream();

            byte buf[] = new byte[64 * 1024];

            int r = is.read(buf);
            if (r > 0) {

                String data = new String(buf, 0, r);

                System.out.println(data);
            }
        }
    }
}

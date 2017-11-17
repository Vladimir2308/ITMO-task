package lecture15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PrintServer {

    private int port;
    private Map<String, String> map;

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    private PrintServer(int port) {
        this.port = port;
        map = new HashMap<>();
    }

    private void start() throws IOException {
        try (ServerSocket ssocket = new ServerSocket(port)) {
            System.out.println("Server15 started on " + ssocket);

            while (true) {

                try (Socket sock = ssocket.accept()) {
                    process(sock);
                } catch (ClassNotFoundException e) {
                    System.err.println("Wrong message was received");

                    e.printStackTrace();
                }
            }
        }
    }

    private void process(Socket sock) throws IOException, ClassNotFoundException {
        String host = sock.getInetAddress().getHostAddress();

        ObjectInputStream objIn = new ObjectInputStream(sock.getInputStream());
        ObjectOutputStream objOut = new ObjectOutputStream(sock.getOutputStream());
        Object obj = objIn.readObject();
        System.out.println(obj + " !!!");

        if (obj instanceof Message) {
            System.out.println("obj instanceof Message");
            Message msg = (Message) obj;
            printMessage(msg, host);
            map.put(format.format(new Date(msg.getTimestamp())), host);
        } else if (obj instanceof Command) {
            System.out.println("obj instanceof Command");
            objOut.writeObject(doCommand((Command) obj));
        }

    }

    private Command doCommand(Command cmd) {
        switch (cmd.getText()) {
            case "/list_users":
                cmd.setObj(map);
                break;
            case "/server_time":
                cmd.setObj(System.currentTimeMillis());
                break;
            case "/ping":
                break;
        }
        return cmd;
    }

    private void printMessage(Message msg, String senderAddr) {
        System.out.printf("%s (%s) at %s wrote: %s\n", msg.getSender(), senderAddr, format.format(new Date(msg.getTimestamp())), msg.getText());
    }

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0)
            throw new IllegalArgumentException("Port must be specified");

        int port = Integer.parseInt(args[0]);

        PrintServer printServer = new PrintServer(port);

        printServer.start();
    }
}

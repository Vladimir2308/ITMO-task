package lecture15;

import java.io.*;
import java.net.*;
import java.util.*;


public class PrintClient {

    private SocketAddress serverAddr;

    private String name;

    private Scanner scanner;

    private PrintClient(SocketAddress serverAddr, Scanner scanner) {
        this.serverAddr = serverAddr;
        this.scanner = scanner;
    }

    private void start() throws IOException, ClassNotFoundException {
        System.out.println("Enter your name: ");

        name = scanner.nextLine();

        while (true) {
            System.out.println("Enter message to send: ");

            String msg = scanner.nextLine();

            if ("/exit".equals(msg))
                break;
            else if ("/nick".equals(msg)) {
                System.out.println("Enter new name:");

                name = scanner.nextLine();

                continue;
            } else if ("/myaddr".equals(msg)) {
                printAddresses();

                continue;
            } else if ("/list_users".equals(msg)) {
                Command cmd = new Command("/list_users");
                sendPrintMessage(cmd);
                continue;
            } else if ("/server_time".equals(msg)) {
                Command cmd = new Command("/server_time");
                sendPrintMessage(cmd);
                continue;
            } else if ("/ping".equals(msg)) {
                Command cmd = new Command("/ping");
                cmd.setObj(System.nanoTime());
                sendPrintMessage(cmd);
                continue;
            }
            buildAndSendMessage(msg);
        }
    }

    private void printAddresses() throws SocketException {
        Enumeration e = NetworkInterface.getNetworkInterfaces();

        while (e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();

            Enumeration ee = n.getInetAddresses();

            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();

                System.out.println(i.getHostAddress());
            }
        }
    }

    private void buildAndSendMessage(String msg) throws IOException {
        Message message = new Message(System.currentTimeMillis(), name, msg);

        sendPrintMessage(message);

        System.out.println("Sent: " + message);
    }

    private void sendPrintMessage(Message obj) throws IOException {
        try (Socket sock = new Socket()) {
            sock.connect(serverAddr);
            try (OutputStream out = sock.getOutputStream()
            ) {
                ObjectOutputStream objOut = new ObjectOutputStream(out);
                objOut.writeObject(obj);
                objOut.flush();
            }
        }

    }

    private void sendPrintMessage(Command cmd) throws IOException, ClassNotFoundException {
        try (Socket sock = new Socket()) {
            System.out.println(cmd);
            sock.connect(serverAddr);
            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

                ObjectOutputStream objOut = new ObjectOutputStream(out);
                ObjectInputStream objIn = new ObjectInputStream(in);
                objOut.writeObject(cmd);
                objOut.flush();
                printResponse(objIn.readObject());
            }
        }



    private void printResponse(Object o) {
        if (o instanceof Command) {
            Command cmd = (Command) o;
            String txt = cmd.getText();
            switch (txt) {
                case "/list_users":
                    PrintMap((Map) cmd.getObj());
                    break;
                case "/server_time":
                    System.out.println("Server time: " + new Date((Long) cmd.getObj()));
                    break;
                case "/ping":
                    System.out.println((System.nanoTime() - (Long) cmd.getObj()) / 1000000 + " mls");
                    break;
            }
        } else
            System.out.println(o);
    }

    private void PrintMap(Map m) {
        Iterator<Map.Entry<String, Integer>> entries = m.entrySet().iterator();
        int i = 0;
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            System.out.println(i++ + "  time: " + entry.getKey() + " IP: " + entry.getValue());
        }
    }

    private static SocketAddress parseAddress(String addr) {
        String[] split = addr.split(":");
        return new InetSocketAddress(split[0], Integer.parseInt(split[1]));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String addr = "localhost:12345";

        if (args != null && args.length > 0)
            addr = args[0];

        Scanner scanner = new Scanner(System.in);

        if (addr == null) {
            System.out.println("Enter server address");

            addr = scanner.nextLine();
        }

        PrintClient client = new PrintClient(parseAddress(addr), scanner);

        client.start();
    }
}

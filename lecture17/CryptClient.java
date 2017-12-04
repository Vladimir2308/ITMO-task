package lecture17;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.SecureRandom;

public class CryptClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 12345));
        try (
                ObjectInputStream objIn = new ObjectInputStream(new CryptInputStream(socket.getInputStream()));
//                ObjectInputStream objIn = new ObjectInputStream(new com.itmo.patterns.CryptoInputStream(socket.getInputStream(),"Hello".getBytes()));
        ) {
            System.out.println(objIn.readObject());
        }
    }
}

class CryptInputStream extends FilterInputStream {
    //    static int bufferLength = 1024;
//    byte[] buffer = new byte[bufferLength];
    final static byte[] key = "Hello".getBytes();
    int readed = -1;
    int attempt = 4;

    public CryptInputStream(InputStream in) throws IOException {
        super(in);

    }

    @Override
    public int read() throws IOException {
        byte b;
        int res = super.read();

        if (res < 0)
            return res;

        b = (byte) res;
        if (++readed > key.length) readed = 0;
        b ^= key[readed];
        return b & 0xFF;
    }


    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = super.read(b, off, len);

        if (read > 0) {

            for (int i = off; i < read + off; i++) {
                if (++readed > key.length-1) readed = 0;
                b[i] ^= key[readed];


            }
        }

        return read;
    }


    private static byte[] getNextRandomString(int size) {
        SecureRandom rnd = new SecureRandom();
        byte[] token = new byte[size];
        rnd.nextBytes(token);
        return token;
    }


}

class CryptOutPutStream extends FilterOutputStream {
    //    private static int bufferLength = CryptInputStream.bufferLength;
//    byte[] buffer = new byte[bufferLength];
    final static byte[] key = "Hello".getBytes();
    int keyNum = -1;
    int writed = 0;

    public CryptOutPutStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        byte b1 = (byte) b;
        if (++keyNum > key.length - 1) {
            keyNum = 0;
        }
        b1 ^= key[keyNum];
        System.out.println(" b = " + b + " idx " + keyNum + " b1 " + b1);
        out.write(b1);

    }

}

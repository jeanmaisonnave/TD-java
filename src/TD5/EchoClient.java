package TD5;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        DataInputStream dataInput = null;

        try {
            echoSocket = new Socket("localhost", 4444);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            dataInput = new DataInputStream(echoSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host : localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to taranis.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("send a message to the server:");
        String userInput = stdIn.readLine();
        out.println(userInput);
        System.out.println("echo:" + dataInput.readUTF());

        out.close();
        dataInput.close();
        stdIn.close();
        echoSocket.close();
    }
}

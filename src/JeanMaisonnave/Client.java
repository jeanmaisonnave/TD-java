package JeanMaisonnave;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client démarré ...");
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        DataInputStream dataInput = null;
        String host = "localhost";
        int port = 4444;

        try {
            System.out.println("Tentative de connexion au serveur " + host + "@" + port + " ...");
            echoSocket = new Socket(host, port);
            System.out.println("Connexion au serveur réussie");
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            dataInput = new DataInputStream(echoSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host : localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to localhost.");
            System.exit(1);
        }

        ClientFrame mainWindow = new ClientFrame(echoSocket);

        /*out.close();
        dataInput.close();
        stdIn.close();
        echoSocket.close();*/
    }
}

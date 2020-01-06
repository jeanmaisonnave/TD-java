package TD5;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = null;
        Socket socketReception = null;
        Socket socketEnvoi = null;
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            System.out.println("Démarrage du client 1 ...");
            serverSocket = new ServerSocket(4444);

            System.out.println("Tentative de connexion au client 2 ...");
            socketEnvoi = new Socket("localhost",5555);
            System.out.println("Connexion au client 2 réussie");

            System.out.println("Client 1 en attente de connexion du client 2 ...");
            socketReception = serverSocket.accept();
            System.out.println("Client 1 connecté au Client 2");

            out = new BufferedWriter(new OutputStreamWriter(socketEnvoi.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socketReception.getInputStream()));

            Comunica mainWindow = new Comunica(out,in);
            mainWindow.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
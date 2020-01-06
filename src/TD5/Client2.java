package TD5;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = null;
        Socket socketReception = null;
        Socket socketEnvoi = null;
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            System.out.println("Démarrage du client 2 ...");
            serverSocket = new ServerSocket(5555);

            System.out.println("client 2 en attente de connexion du client 1 ...");
            socketReception = serverSocket.accept();
            System.out.println("client 1 connecté au client 2 ...");

            System.out.println("Tentative de connexion au client 1 ...");
            socketEnvoi = new Socket("localhost",4444);
            System.out.println("Connexion au client 1 réussie");

            out = new BufferedWriter(new OutputStreamWriter(socketEnvoi.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socketReception.getInputStream()));

            Comunica mainWindow = new Comunica(out,in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package TD5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServeur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            try {
                Socket clientSocket = serverSocket.accept();

                DataInputStream dataInput = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

                BufferedReader br = new BufferedReader(new InputStreamReader(dataInput));
                System.out.println("serveur...");
                String message = br.readLine();
                System.out.println("Message reçu :" + message);
                dataOut.writeUTF(message);
                clientSocket.close();
                dataOut.close();
                dataInput.close();
            } catch (IOException e) {
                System.out.println("Accept failed: 4444");
                System.exit(-1);
            }
        } catch (IOException e) {
            System.out.println("Couldn't not listen on port: 4444");
            System.exit(-1);
        }
    }
}

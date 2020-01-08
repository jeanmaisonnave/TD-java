package Tamagochi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Serveur {
    private Tamagochi tamagochi;

    public void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            try {
                System.out.println("Serveur démarré en attente de connexion ...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Serveur connecté au client ...");

                DataInputStream dataInput = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

                BufferedReader br = new BufferedReader(new InputStreamReader(dataInput));

                while (true) {
                    //System.out.println("serveur en attente d'un message du client ...");
                    //System.out.println(System.currentTimeMillis());
                    String message = br.readLine();
                    //System.out.println("message reçu de la part du client : \'" + message + "\'");
                    switch (message) {
                        case "creer":
                            //on crée le tamagochi
                            tamagochi = new Tamagochi();
                            tamagochi.start();
                            dataOut.writeUTF("Tamagochi cree");
                            System.out.println("Tamagochi est créé");
                            break;
                        case "etat":
                            //on renvoie l'état du tamagochi
                            String etat = "lieu:" + tamagochi.getLieu() +
                                    ";satiete:" + tamagochi.getSatitete() +
                                    ";emotion:" + tamagochi.getEmotion() +
                                    ";sante:" + tamagochi.getSante() +
                                    ";dernier repas:" + tamagochi.getDernierRepas() +
                                    ";dernier mecontentement:" + tamagochi.getDernierMecontement() +
                                    ";age:" + tamagochi.getAge();
                            dataOut.writeUTF(etat);
                            //System.out.println("message envoyé au client : \'" + etat + "\'");
                            break;
                        case "table":
                            //on met le tamagochi à table
                            tamagochi.setLieu("table");
                            tamagochi.setDernierRepas(new Date(System.currentTimeMillis()));
                            System.out.println("Tamagochi est à table");
                            break;
                        case "salle de jeu":
                            //on met le tamagochi dans la salle de jeu
                            tamagochi.setLieu("salle de jeu");
                            System.out.println("Tamagochi est dans la salle de jeu");
                            break;
                    }

                }

                /*clientSocket.close();
                dataOut.close();
                dataInput.close();*/
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

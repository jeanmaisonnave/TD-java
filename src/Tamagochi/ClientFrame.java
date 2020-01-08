package Tamagochi;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.*;

@SuppressWarnings("serial")
public class ClientFrame extends JFrame {

    private JLabel age;
    private JTextArea logs;
    private JScrollPane scrolledLogs;
    private JButton aTable;
    private JButton salleDeJeu;
    private BufferedWriter w;
    private BufferedWriter writer;
    private int lastAgeUpdate;
    HashMap<String, String> etat;
    HashMap<String, String> oldEtat;

    PrintWriter out;
    DataInputStream dataInput;


    private Socket socket;

	/**
	 *
	 * @param socket
	 */
    public ClientFrame(Socket socket) {

        initFrame();
        oldEtat = null;
        etat = new HashMap<>();
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            dataInput = new DataInputStream(socket.getInputStream());
            String m = "creer";
            out.println(m);
            System.out.println("Envoi du message : \'" + m + "\'");
            String message = dataInput.readUTF();
            System.out.println("Message reçu : \'" + message + "\'");

            if (message.equals("Tamagochi cree")) {
                updateLogs("Tamagochi créé");
            } else {
                System.err.println("Erreur du serveur lors de la création du Tamagochi");
                System.exit(-1);
            }

            while (true) {
                System.out.println("Envoi du message : \'etat\'");
                out.println("etat");
                message = dataInput.readUTF();
                System.out.println("Message reçu : \'" + message + "\'");
                System.out.println();
                String[] messageSplit = message.split(";");

                for (String s : messageSplit) {
                    String[] sSplit = s.split(":");
                    etat.put(sSplit[0], sSplit[1]);
                }

                if (oldEtat != null) {
                    if (!oldEtat.get("satiete").equals(etat.get("satiete"))) {
                        if (etat.get("satiete").equals("faim")) {
                            updateLogs("J'ai faim !");
                        } else if (etat.get("satiete").equals("repu")) {
                            updateLogs("J'ai plus faim !");
                        } else {
                            System.err.println("Erreur de l'état de satiété du Tamagochi");
                            System.exit(-1);
                        }
                    }

                    if (!oldEtat.get("emotion").equals(etat.get("emotion"))) {
						if (etat.get("emotion").equals("content")){
							updateLogs("Je suis content !");
						}else if(etat.get("emotion").equals("mecontent")){
						    updateLogs("Je suis mécontent !");
                        }else {
						    System.err.println("Erreur dans l'émotion du Tamagochi");
						    System.exit(-1);
                        }
                    }

                    if (!oldEtat.get("sante").equals(etat.get("sante"))
                            && etat.get("sante").equals("mort")){
                        updateLogs("Je suis mort !");
                    }
                }

                oldEtat = new HashMap<>(etat);

                int a = Integer.parseInt(etat.get("age")) / 1000;
                System.out.println("age du Tamagochi : " + a);
                updateAge(a);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void initFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setTitle("Tamagochi");
        setSize(400, 400);

        GridBagConstraints c = new GridBagConstraints();
        age = new JLabel("Age: 0 secondes");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        add(age, c);

        logs = new JTextArea(15, 10);
        logs.setText("Logs:");
        scrolledLogs = new JScrollPane(logs);
        scrolledLogs.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolledLogs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 10;
        add(scrolledLogs, c);

        aTable = new JButton("A table!");
        aTable.addActionListener(e -> {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                dataInput = new DataInputStream(socket.getInputStream());
                out.println("table");
                updateLogs("A table !");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1;
        add(aTable, c);

        salleDeJeu = new JButton("Salle de jeu!");
        salleDeJeu.addActionListener(e -> {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                dataInput = new DataInputStream(socket.getInputStream());
                out.println("salle de jeu");
                updateLogs("Salle de jeu!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        add(salleDeJeu, c);
        setVisible(true);
    }

    private void updateAge(int a) {
        age.setText("Age: " + a + " secondes");
    }

    private void updateLogs(String content) {
        String temp = logs.getText() + "\n" + content;
        logs.setText(temp);
    }

    public static void main(String[] args) {

    }
}

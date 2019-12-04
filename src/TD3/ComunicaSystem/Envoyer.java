package TD3.ComunicaSystem;

import TD3.Comunica;

import java.io.*;

public class Envoyer {
    public static void main(String[] args) {

        try {
            File a2b = new File("A2B.txt");
            if (!a2b.exists()) {
                a2b.createNewFile();
            }

            File b2a = new File("B2A.txt");
            if (!b2a.exists()) {
                b2a.createNewFile();
            }

            Comunica mainWindow = new Comunica(a2b.getPath(),b2a.getPath());
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

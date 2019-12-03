package TD3.ComunicaSystem;

import TD3.Comunica;

import java.io.*;

public class Envoyer {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            File a2b = new File("A2B.txt");
            if (!a2b.exists()) {
                a2b.createNewFile();
            }
            FileWriter fw = new FileWriter(a2b);
            bw = new BufferedWriter(fw);

            File b2a = new File("B2A.txt");
            if (!b2a.exists()) {
                b2a.createNewFile();
            }
            FileReader fr = new FileReader(b2a);
            br = new BufferedReader(fr);

            Comunica mainWindow = new Comunica(bw,br);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
            try {
                if(bw!=null)
                    bw.close();
            } catch (IOException ex) {
                System.out.println("Error in closing the BufferedWriter or the BufferedReader" + ex);
                ex.printStackTrace();
            }
            try {
                if(br!=null)
                    br.close();
            } catch (IOException ex) {
                System.out.println("Error in closing the BufferedWriter or the BufferedReader" + ex);
                ex.printStackTrace();
            }
        }
    }
}

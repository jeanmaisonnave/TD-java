package TD5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Readline implements Runnable {
    private Comunica comunica;

    public Readline(Comunica comunica) {
        this.comunica = comunica;
    }


    @Override
    public void run() {
 /*       while(true){
            try {
                Comunica.setR(new BufferedReader(reader));
                textRec.setText(r.readLine());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Message received : " + textRec.getText());
        }*/
    }
}

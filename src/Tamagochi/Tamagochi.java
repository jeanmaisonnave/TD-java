package Tamagochi;

import java.io.Serializable;
import java.util.Date;


public class Tamagochi extends Thread implements Serializable {
    private String lieu;
    private String satiete;
    private String emotion;
    private String sante;
    private Date dernierRepas;
    private Date dernierMecontement;
    private Long age;
    private Date creationTime;

    public Tamagochi() {
        lieu = "salle de jeu";
        satiete = "repu";
        emotion = "content";
        sante = "vivant";
        age = Long.valueOf(0);
        creationTime = new Date(System.currentTimeMillis());
        dernierRepas = null;
        dernierMecontement = null;

    }

    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date currentTime = new Date(System.currentTimeMillis());
            System.out.println(currentTime);
            age = currentTime.getTime() - creationTime.getTime();

            //gestion de l'émotion
            if (emotion.equals("content")) {
                if ((satiete.equals("repu") && lieu.equals("table"))
                        || (satiete.equals("faim") && lieu.equals("salle de jeu"))) {
                    emotion = "mecontent";
                    dernierMecontement = currentTime;
                }
            } else if (emotion.equals("mecontent")) {
                if ((satiete.equals("faim")) && (lieu.equals("table"))
                        || (satiete.equals("repu") && lieu.equals("salle de jeu"))) {
                    emotion = "content";
                    dernierMecontement = null;
                }
            } else {
                System.err.println("Erreur dans l'émotion du Tamagochi");
                System.exit(-1);
            }

            //gestion de la satiété
            if (satiete.equals("repu")) {
                if ((dernierRepas == null) || (currentTime.getTime() > (dernierRepas.getTime() + 120000))) {
                    satiete = "faim";
                }
            } else if (satiete.equals("faim")) {
                if ((dernierRepas != null)
                        && (lieu.equals("table"))
                        && (currentTime.getTime() > (dernierRepas.getTime() + 30000))) {
                    satiete = "repu";
                }
            } else {
                System.err.println("Erreur dans la satiété du Tamagochi");
                System.exit(-1);
            }

            //gestion de la santé
            if ((dernierMecontement != null)
                    && (currentTime.getTime() >= dernierMecontement.getTime() + 60000)) {
                sante = "mort";
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(1);
            }
        }
    }


    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getSatitete() {
        return satiete;
    }

    public void setSatitete(String satitete) {
        this.satiete = satitete;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getSante() {
        return sante;
    }

    public void setSante(String sante) {
        this.sante = sante;
    }

    public Date getDernierRepas() {
        return dernierRepas;
    }

    public void setDernierRepas(Date dernierRepas) {
        this.dernierRepas = dernierRepas;
    }

    public Date getDernierMecontement() {
        return dernierMecontement;
    }

    public void setDernierMecontement(Date dernierMecontement) {
        this.dernierMecontement = dernierMecontement;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}

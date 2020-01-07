package JeanMaisonnave;

import java.io.Serializable;

import static java.lang.System.currentTimeMillis;

public class Tamagochi extends Thread implements Serializable {
    private String lieu;
    private String satitete;
    private String emotion;
    private String sante;
    private Integer dernierRepas;
    private Integer dernierMecontement;
    private Integer age;
    private Integer creationTime;

    public Tamagochi() {
        lieu = "table";
        satitete = "repus";
        emotion = "content";
        sante = "vivant";
        age = 0;
        creationTime = (int)(currentTimeMillis());
        dernierRepas = null;
        dernierMecontement = null;

    }

    public void run(){
        while(true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentTimeMillis());
            age = (int)currentTimeMillis() - creationTime;

            if ((dernierRepas != null ) && (currentTimeMillis() == dernierRepas + 30000)){
                satitete = "repus";
                notifyAll();
            }
            if ((dernierRepas != null) && (currentTimeMillis() >= dernierRepas + 120000)){
                satitete = "faim";
            }
            if((dernierMecontement != null)
                    && (System.currentTimeMillis() >= dernierMecontement + 60000)){
                sante = "mort";
                System.exit(1);
            }
            if((satitete.equals("repu") && lieu.equals("a table"))
                    || (satitete.equals("faim") && lieu.equals("salle de jeu"))){
                dernierMecontement = (int) currentTimeMillis();
                emotion = "mecontent";
            }
            if(((satitete.equals("faim")) && (lieu.equals("a table")))
                    || ((satitete.equals("repu")) && (lieu.equals("salle de jeu")))){
                dernierMecontement = Integer.parseInt(null);
                emotion = "content";
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
        return satitete;
    }

    public void setSatitete(String satitete) {
        this.satitete = satitete;
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

    public Integer getDernierRepas() {
        return dernierRepas;
    }

    public void setDernierRepas(Integer dernierRepas) {
        this.dernierRepas = dernierRepas;
    }

    public Integer getDernierMecontement() {
        return dernierMecontement;
    }

    public void setDernierMecontement(Integer dernierMecontement) {
        this.dernierMecontement = dernierMecontement;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }
}

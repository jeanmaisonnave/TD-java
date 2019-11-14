package TD1.perso;

public class Enseignant extends Personne {
    private  int heures;

    public Enseignant(String nom, int age, int heures) {
        super(nom, age);
        this.heures = heures;
    }

    @Override
    public String toString() {
        return super.toString()+";heures:"+this.heures;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }
}

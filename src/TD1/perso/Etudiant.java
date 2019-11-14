package TD1.perso;

public class Etudiant extends Personne {
    private float note;

    public Etudiant(String nom, int age, int note) {
        super(nom, age);
        this.note = note;
    }

    @Override
    public String toString() {
        return super.toString()+";note:"+this.note;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}

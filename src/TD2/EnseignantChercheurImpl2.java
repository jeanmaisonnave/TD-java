package TD2;

import TD1.perso.*;
import java.util.Vector;

public class EnseignantChercheurImpl2 extends Enseignant implements Chercheur {

    private Vector<Publication> publications = new Vector<>();

    public EnseignantChercheurImpl2(String nom, int age, int heures) {
        super(nom, age, heures);
    }

    public EnseignantChercheurImpl2(String nom, int age, int heures, Vector<Publication> publications) {
        super(nom, age, heures);
        this.publications = publications;
    }

    @Override
    public void ajouterPublication(Publication p) {
        if (publications.size() <= 10) {
            publications.add(p);
        }
    }

    @Override
    public String listerPublications() {
        String r = "";
        for(Publication p : publications){
            r += p.toString() + ",";
        }
        if (r.length() > 0){
            r = r.substring(0, r.length() - 1);
        }
        return r;
    }

    @Override
    public String toString(){
        String r = "";
        if (publications.size() > 0) {
            r = super.toString() + ";publications:" + listerPublications();
        }else {
            r = "no publications";
        }
        return r;
    }

    public Vector<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Vector<Publication> publications) {
        this.publications = publications;
    }
}

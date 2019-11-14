package TD2;

import TD1.perso.*;
import java.util.HashMap;

public class EnseignantChercheurImpl3 extends Enseignant implements Chercheur {

    private HashMap<Integer,Publication> publications = new HashMap<Integer,Publication>();

    public EnseignantChercheurImpl3(String nom, int age, int heures) {
        super(nom, age, heures);
    }

    public EnseignantChercheurImpl3(String nom, int age, int heures, HashMap<Integer,Publication> publications) {
        super(nom, age, heures);
        this.publications = publications;
    }

    @Override
    public void ajouterPublication(Publication p) {
        if (publications.size() <= 10) {
            publications.put(publications.size(),p);
        }
    }

    @Override
    public String listerPublications() {
        String r = "";
        for (int i = 0; i < publications.size(); i++) {
            r += publications.get(i).toString() + ",";
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

    public HashMap<Integer,Publication> getPublications() {
        return publications;
    }

    public void setPublications(HashMap<Integer,Publication> publications) {
        this.publications = publications;
    }
}

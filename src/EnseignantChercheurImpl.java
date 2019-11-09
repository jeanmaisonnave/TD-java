import perso.*;
import java.util.ArrayList;

public class EnseignantChercheurImpl extends Enseignant implements Chercheur {

    private ArrayList<Publication> publications = new ArrayList<Publication>();

    public EnseignantChercheurImpl(String nom, int age, int heures) {
        super(nom, age, heures);
    }

    public EnseignantChercheurImpl(String nom, int age, int heures, ArrayList<Publication> publications) {
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

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }
}

package TD1;

import TD1.perso.*;

import java.util.ArrayList;

public class HelloPersonnes {
    public static void main(String args[]){
        ArrayList<Personne> personnes = new ArrayList<>();
        Personne enaut = new Personne("Enaut",23);
        Personne joe = new Etudiant("Joe",25,0);
        Personne landry = new Enseignant("Landry",24,35);
        personnes.add(enaut);
        personnes.add(joe);
        personnes.add(landry);
        for(Personne p:personnes){
            System.out.println(p.toString());
        }
    }
}

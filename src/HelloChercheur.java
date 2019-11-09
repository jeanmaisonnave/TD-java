import perso.*;
public class HelloChercheur {
    public static void main(String[] args) {
        //Test implémentation avec ArrayList
        // Creation of the objects
        Chercheur chercheur = new EnseignantChercheurImpl("tom", 35,192);
        chercheur.ajouterPublication(new Publication("La conception objet",2003));
        chercheur.ajouterPublication(new Publication("La programmation objet",2004));
        // printing the object attributes
        System.out.println(chercheur);

        //Test implémentation avec Vector
        // Creation of the objects
        chercheur = new EnseignantChercheurImpl2("tom", 35,192);
        chercheur.ajouterPublication(new Publication("La conception objet",2003));
        chercheur.ajouterPublication(new Publication("La programmation objet",2004));
        // printing the object attributes
        System.out.println(chercheur);

        //Test implémentation avec HashMap
        // Creation of the objects
        chercheur = new EnseignantChercheurImpl3("tom", 35,192);
        chercheur.ajouterPublication(new Publication("La conception objet",2003));
        chercheur.ajouterPublication(new Publication("La programmation objet",2004));
        // printing the object attributes
        System.out.println(chercheur);

    }
}
public class Publication {
    private String titre;
    private int annee;
    public Publication(String titre, int annee) {
        this.titre=titre;
        this.annee=annee;
    }
    public String getTitre() {
        return titre;
    }
    public int getAnnee() {
        return annee;
    }
    public String toString() {
        return getTitre()+"/"+getAnnee();
    }
}

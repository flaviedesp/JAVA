
public class Vendeur {

    private String nom;
    private String prenom;
    private Garage garage;

    public Vendeur(String prenom, String nom, Garage garage) {
        this.prenom = prenom;
        this.nom = nom;
        this.garage = garage;
    }

    public String toString() {
        return prenom + " " + nom + "\n" + garage + "\n";

    }

    public String getNom() {
        return nom;
    }
}

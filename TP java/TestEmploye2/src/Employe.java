
public class Employe
{

    private int matricule;
    private String nom;
    private static int numeroAutomatique = 100;
    private static int compteur;

    public Employe(String nom, int matricule)
    {
        compteur++;
        this.nom = nom;
        this.matricule = matricule;
    }

    public Employe(String nom)
    {
        compteur++;
        this.nom = nom;
        this.matricule = numeroAutomatique;
        numeroAutomatique++;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getNom()
    {
        return nom;
    }

    public static int getNumeroAutomatique()
    {
        return numeroAutomatique;
    }

    public static int getCompteur()
    {
        return compteur;
    }

    public String toString()
    {
        return "Nom         :" + nom + "\n"
                + "Matricule  :" + matricule;
    }
}

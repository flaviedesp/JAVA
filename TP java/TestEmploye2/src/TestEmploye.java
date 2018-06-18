

import utilitairesMG.divers.*;

public class TestEmploye
{

    public static void main(String argv[])
    {
        Employe e1, e2, e3;
        String nom;

        e1 = new Employe("MERLE");
        System.out.println(e1);

        e2 = new Employe("COLIBRI");
        System.out.println("\n" + e2);

        e3 = new Employe("VAUTOUR");
        System.out.println("\n" + e3);

        System.out.println("\nNombre d'employés crées : " + Employe.getCompteur());
        System.out.println("Prochain matricule automatique : " + Employe.getNumeroAutomatique());
        System.out.print("\nNouveau Nom de l'employé " + e3.getNom() + " : ");
        nom = Clavier.readString();
        e3.setNom(nom);
        System.out.println(e3);
    }

}

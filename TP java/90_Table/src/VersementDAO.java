import java.util.*;
import utilitairesMG.divers.*;

public class VersementDAO
{

// -------------------------------------------------------------------------- 
// Creation de la liste des Contacts a afficher dans la JTable
// -------------------------------------------------------------------------- 
// Remarque : listeContacts est un vecteur d'objets Contact...
// -------------------------------------------------------------------------- 
    public Vector<Versement> creeListeVersement()
    {
        Vector<Versement> listeVersement = new Vector<Versement>();
        Versement versement;

        versement = new Versement();
        versement.setNumero(200);
        versement.setNom("INNAL");
        versement.setAdresse("Rue des bons coucous");
        versement.setCodePostal("94250");
        versement.setVille("GENTILLY");
        versement.setCodeSecteur(1);

        listeVersement.addElement(versement);

        versement = new Versement();
        versement.setNumero(201);
        versement.setNom("BASTARD");
        versement.setAdresse("Avenue du gros Merdier");
        versement.setCodePostal("75004");
        versement.setVille("PARIS");
        versement.setCodeSecteur(3);

        listeVersement.addElement(versement);

        versement = new Versement();
        versement.setNumero(303);
        versement.setNom("MERDE");
        versement.setAdresse("Rue Albert Einstein");
        versement.setCodePostal("22000");
        versement.setVille("DINAN");
        versement.setCodeSecteur(3);

        listeVersement.addElement(versement);
        
        versement = new Versement();
        versement.setNumero(525);
        versement.setNom("METHOD");
        versement.setAdresse("Rue Wu-Tang");
        versement.setCodePostal("00001");
        versement.setVille("NewYork");
        versement.setCodeSecteur(3);

        listeVersement.addElement(versement);
        
        versement = new Versement();
        versement.setNumero(634);
        versement.setNom("MAN");
        versement.setAdresse("Impasse de la Liberté");
        versement.setCodePostal("00000");
        versement.setVille("HELL");
        versement.setCodeSecteur(3);

        listeVersement.addElement(versement);

        return listeVersement;
    }

// -------------------------------------------------------------------------- 
// Creation de la liste des colonnes a afficher dans la JTable
// -------------------------------------------------------------------------- 
    public Vector<Colonne> creeListeColonnes()
    {
        Vector<Colonne> listeColonnes = new Vector<Colonne>();

// --------------------------------------------------------------------------
// Creation du vecteur des colonnes
// --------------------------------------------------------------------------
        listeColonnes.addElement(
            new Colonne("NUMERO", new Integer(5), "java.lang.Integer"));

        listeColonnes.addElement(
            new Colonne("NOM", new Integer(20), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("ADRESSE", new Integer(50), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("CODE_POSTAL", new Integer(12), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("VILLE", new Integer(20), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("CODE_SECTEUR", new Integer(1), "java.lang.Integer"));

        return listeColonnes;
    }
}

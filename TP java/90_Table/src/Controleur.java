// ==========================================================================
// La JTable est modifiable.
// ==========================================================================

import java.util.*;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class Controleur
{
    private static Fenetre fenetre;
    private static ContactDAO contactDAO;
    private static VersementDAO versementDAO;

// -------------------------------------------------------------------------- 
// Programme principal de l'application.
// -------------------------------------------------------------------------- 
    public static void main(String args[])
    {
//        Vector<Colonne> listeColonnes;
//        Vector<Contact> listeContacts;
//
//// -------------------------------------------------------------------------- 
//// Creation des vecteurs des donnees a afficher.
//// -------------------------------------------------------------------------- 
//        contactDAO = new ContactDAO();
//        listeContacts = contactDAO.creeListeContacts();
//        listeColonnes = contactDAO.creeListeColonnes();

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable()
            {
                public void run()
                {
                    LF.setLF();
                    fenetre = 
                        new Fenetre("JTable éditable - MVC - DAO");
                }
            }
        );
    }

// -------------------------------------------------------------------------- 
// Arret de l'application.
// -------------------------------------------------------------------------- 
    public static void arreter()
    {
        System.exit(0);
    }
    public static void arret(Vector<Contact> listeContacts,
                               Vector<Contact> listeContactsModifies,
                               Vector<Contact> listeContactsInseres)
    {
        System.out.println("Tous les contacts :\n" + listeContacts);
        System.out.println("\n\nContacts modifies :\n" + listeContactsModifies);
        System.out.println("\n\nContacts inseres :\n" + listeContactsInseres);
        //System.exit(0);
    }

     public static void arretV(Vector<Versement> listeVersement,
                               Vector<Versement> listeVersementModifies,
                               Vector<Versement> listeVersementInseres)
    {
        System.out.println("Tous les contacts :\n" + listeVersement);
        System.out.println("\n\nContacts modifies :\n" + listeVersementModifies);
        System.out.println("\n\nContacts inseres :\n" + listeVersementInseres);
        //System.exit(0);
    }

    public static void chercheContact(JDesktopPane p){
        Vector<Colonne> listeColonnes;
        Vector<Contact> listeContacts;

// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees contact a afficher.
// -------------------------------------------------------------------------- 
        contactDAO = new ContactDAO();
        listeContacts = contactDAO.creeListeContacts();
        listeColonnes = contactDAO.creeListeColonnes();
        
        if (listeContacts == null){
            info("contacts");
        }else{
            SousFenetre sousFenetre = new SousFenetre("Contact", listeContacts,listeColonnes, p);
        }   
    }
   
   
        public static void chercheVersement(JDesktopPane p){
        Vector<Colonne> listeColonnes;
        Vector<Versement> listeVersement;

// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees versement a afficher.
// -------------------------------------------------------------------------- 
        versementDAO = new VersementDAO();
        
        listeVersement = versementDAO.creeListeVersement();
        listeColonnes = versementDAO.creeListeColonnes();
        
        if (listeVersement == null){
            info("versements");
        }else{
            SousFenetreVersement sousFenetre = new SousFenetreVersement("Versement", listeVersement,listeColonnes, p);
        }   
    }
    
    public static void info(String s){
            JOptionPane jop;

            jop = new JOptionPane();
            jop.showMessageDialog(null, "Gestion des " + s + " non réalisés", "Information", JOptionPane.INFORMATION_MESSAGE);

    }
    
}

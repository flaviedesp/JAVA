// ==========================================================================
// La JTable est modifiable.
// ==========================================================================

import java.util.*;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class Controleur
{
    private static Fenetre fenetre;
    private static ContactDAO contactDAO;

// -------------------------------------------------------------------------- 
// Programme principal de l'application.
// -------------------------------------------------------------------------- 
    public static void main(String args[])
    {
        Vector<Colonne> listeColonnes;
        Vector<Contact> listeContacts;

// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
        contactDAO = new ContactDAO();
        listeContacts = contactDAO.creeListeContacts();
        listeColonnes = contactDAO.creeListeColonnes();

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
                        new Fenetre("JTable éditable - MVC - DAO", 
                                    listeContacts, 
                                    listeColonnes);
                }
            }
        );
    }

// -------------------------------------------------------------------------- 
// Arret de l'application.
// -------------------------------------------------------------------------- 
    public static void arreter(Vector<Contact> listeContacts,
                               Vector<Contact> listeContactsModifies,
                               Vector<Contact> listeContactsInseres)
    {
        System.out.println("Tous les contacts :\n" + listeContacts);
        System.out.println("\n\nContacts modifies :\n" + listeContactsModifies);
        System.out.println("\n\nContacts inseres :\n" + listeContactsInseres);
        System.exit(0);
    }
}

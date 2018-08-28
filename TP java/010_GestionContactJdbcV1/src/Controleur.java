// ==========================================================================
// Classe Controleur                              Projet GestionContactJdbcV1
// ==========================================================================

import metierMapping.*;
import daoJdbcMapping.ContactDAO;
import daoJdbcMapping.SecteurDAO;
import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.*;
import utilitairesMG.jdbc.*;
import java.sql.*;

public class Controleur {

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
    private static Fenetre maFenetre;
    private static ContactDAO contactDAO;
    private static BaseDeDonnees base;
    private static AccesBase accesBase;
    private static SecteurDAO secteurDAO;

// --------------------------------------------------------------------------
// Methode main : lancement de l'application
// --------------------------------------------------------------------------
    public static void main(String args[]) {

// --------------------------------------------------------------------------
// Chargement du driver SQL
// --------------------------------------------------------------------------
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver inconnu : " + e.getMessage());
            System.exit(0);
        }

// --------------------------------------------------------------------------
// Base de donnees utilisee
// --------------------------------------------------------------------------
        base = new BaseDeDonnees(
                "jdbc:sqlserver://mars;databasename=gnmi;"
                + "user=util_bip;password=x");
        base.setFormatDate("dd/MM/yyyy");

        accesBase = new AccesBase(base);

// --------------------------------------------------------------------------
// Creation de l'objet DAO
// --------------------------------------------------------------------------
        contactDAO = new ContactDAO(accesBase);
        secteurDAO = new SecteurDAO(accesBase);

// --------------------------------------------------------------------------
// Affichage de la fenetre de l'application
// --------------------------------------------------------------------------
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                LF.setLF();
                maFenetre = new Fenetre("GestionContactJdbc - Version 1");
            }
        }
        );
    }

// --------------------------------------------------------------------------
// Creation du vecteur des contacts et du vecteur des colonnes a afficher.
// Appel de l'affichage de la fenetre contact...
// --------------------------------------------------------------------------
    public static void demandeContacts() {
        Vector<Contact> listeContacts;
        Vector<Colonne> listeColonnes;
        Vector<Secteur> listeSecteur;

        try {
            accesBase.getConnection();

            try {
                listeContacts = contactDAO.lireListe();
                listeColonnes = contactDAO.getListeColonnes();
                listeSecteur = secteurDAO.lireListe();

                maFenetre.afficheContacts(listeContacts, listeColonnes, listeSecteur);
            } catch (SQLException e) {
                maFenetre.afficheMessage(e.getMessage());
            } finally {
                accesBase.closeConnection();
            }
        } catch (SQLException e) {
            maFenetre.afficheMessage(e.getMessage());
        }
    }

// --------------------------------------------------------------------------
// Creation du vecteur des versements et du vecteur des colonnes a afficher.
// --------------------------------------------------------------------------
    public static void demandeVersements() {
        maFenetre.afficheMessage("Gestion des versements non réalisée");
    }

// --------------------------------------------------------------------------
// Creation du vecteur des secteurs et du vecteur des colonnes a afficher.
// --------------------------------------------------------------------------
    public static void demandeSecteurs() {
        maFenetre.afficheMessage("Gestion des secteurs non réalisée");
    }

// --------------------------------------------------------------------------
// Mise a jour de la table CONTACT.
// --------------------------------------------------------------------------
// Cette methode est appelee lors de la fermeture de la fenetre interne
// Contact.
// --------------------------------------------------------------------------
    public static void majContacts(Vector<Contact> contactsModifies,
            Vector<Contact> contactsInseres,
            Vector<Contact> contactsSupprimes) throws SQLException {

// --------------------------------------------------------------------------
// Mise a jour de l'affichage de la fenetre principale. Ici, cela consiste
// a revalider le menu d'affichage de la table CONTACT.
// --------------------------------------------------------------------------
        maFenetre.valideItemContact();
        Connection connexion;

// --------------------------------------------------------------------------
// Affichage des vecteurs de contacts recus par la methode.
// --------------------------------------------------------------------------
        System.out.println("\nListe des contacts modifies :\n");
        try {
            connexion = accesBase.getConnection();
            try {
                connexion.setAutoCommit(false);
                try {
                    if (contactsModifies.size() == 0) {
                        System.out.println("Il n'y a pas de contacts modifies.");
                    } else {
                        for (int i = 0; i < contactsModifies.size(); i++) {
                            contactDAO.modifier(contactsModifies.elementAt(i));
                            System.out.println(contactsModifies.elementAt(i));
                        }
                    }

                    System.out.println("\n\nListe des contacts inseres :\n");

                    if (contactsInseres.size() == 0) {
                        System.out.println("Il n'y a pas de contacts inseres.");
                    } else {
                        for (int i = 0; i < contactsInseres.size(); i++) {
                            contactDAO.creer(contactsInseres.elementAt(i));
                            System.out.println(contactsInseres.elementAt(i));
                        }
                    }

                    System.out.println("\n\nListe des contacts supprimes :\n");

                    if (contactsSupprimes.size() == 0) {
                        System.out.println("Il n'y a pas de contacts supprimes.");
                    } else {
                        for (int i = 0; i < contactsSupprimes.size(); i++) {
                            contactDAO.detruire(contactsSupprimes.elementAt(i));
                            System.out.println(contactsSupprimes.elementAt(i));
                        }
                    }
                    connexion.commit();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    connexion.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Erreur setAutoCommit().");
                System.out.println(e.getMessage());
            } finally {
                accesBase.closeConnection();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            maFenetre.afficheMessage(e.getMessage());
        }
    }

// --------------------------------------------------------------------------
// Arret de l'application.
// --------------------------------------------------------------------------
    public static void arreter() {
        System.exit(0);
    }
}


import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import utilitairesMG.divers.*;
import utilitairesMG.jdbc.*;

public class ContactDAO implements java.io.Serializable {

    private JeuResultat resultat;
    private Vector<Vector<Object>> lignes;
    private Vector<Contact> listeContacts = new Vector<Contact>();
    private Contact contact;
    private Vector<Object> ligne;   

    
    // -------------------------------------------------------------------------- 
    // Creation de la liste des Contacts a afficher dans la JTable
    // -------------------------------------------------------------------------- 

    public Vector<Contact> creeListeContacts(AccesBase accesBase) throws SQLException {

        int iLigne;
        
        resultat = accesBase.executeQuery("SELECT * FROM CONTACT");

        lignes = resultat.getLignes();

        ligne = new Vector<Object>();
        for (iLigne = 0; iLigne < lignes.size(); iLigne++) {
            contact = new Contact();
            contact.setNumero((Integer) lignes.get(iLigne).get(0));
            contact.setNom((String) lignes.get(iLigne).get(1));
            contact.setAdresse((String) lignes.get(iLigne).get(2));
            contact.setCodePostal((String) lignes.get(iLigne).get(3));
            contact.setVille((String) lignes.get(iLigne).get(4));
            contact.setCodeSecteur((Integer) lignes.get(iLigne).get(5));

            listeContacts.addElement(contact);
        }
        return listeContacts;
    }

// -------------------------------------------------------------------------- 
// Creation de la liste des colonnes a afficher dans la JTable
// -------------------------------------------------------------------------- 
    public Vector<Colonne> creeListeColonnes() {
        return resultat.getColonnes();
    }
}

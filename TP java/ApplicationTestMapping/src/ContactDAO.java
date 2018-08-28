
import java.sql.SQLException;
import java.util.Vector;
import utilitairesMG.divers.Colonne;
import utilitairesMG.divers.Conversion;
import utilitairesMG.jdbc.AccesBase;
import utilitairesMG.jdbc.JeuResultat;

public class ContactDAO {

    private AccesBase accesBase;
    private JeuResultat jeuResultat;

    public ContactDAO(AccesBase accesBase) {
        this.accesBase = accesBase;
    }

    public Contact lire(Contact contact) throws SQLException {

        //Vector<Contact> listeContacts;

// --------------------------------------------------------------------------
// SELECT a executer
// --------------------------------------------------------------------------
        String select = "SELECT * FROM CONTACT WHERE NUMERO =" + contact.getNumero();
       
        Vector ligneContact;
        
        jeuResultat = accesBase.executeQuery(select);

        //listeContacts = new Vector<Contact>();       
        
            ligneContact = (Vector) ((jeuResultat.getLignes()).elementAt(0));

            //contact.setNumero((Integer) ligneContact.elementAt(0));
            contact.setNom((String) ligneContact.elementAt(1));
            contact.setAdresse((String) ligneContact.elementAt(2));
            contact.setCodePostal((String) ligneContact.elementAt(3));
            contact.setVille((String) ligneContact.elementAt(4));
            contact.setCodeSecteur((Integer) ligneContact.elementAt(5));
            //listeContacts.addElement(contact);
        

        return contact;
    }
    
       public int updateContact(Contact contact) throws SQLException{
           String update = "UPDATE CONTACT SET NOM = " 
                   + Conversion.chaineSQL(contact.getNom())+ ","
                   +"ADRESSE =" + Conversion.chaineSQL(contact.getAdresse())+","
                   +"CODE_POSTAL=" + Conversion.chaineSQL(contact.getCodePostal())+","
                   +"VILLE=" + Conversion.chaineSQL(contact.getVille())+","
                   +"CODE_SECTEUR="+ contact.getCodeSecteur() ;
           int codeRetour = accesBase.executeUpdate(update);
           return codeRetour;
       }
        public int insertContact(Contact contact) throws SQLException{
           String insert = "INSERT INTO CONTACT VALUES (" 
                   + Conversion.chaineSQL(contact.getNom())+ ","
                   + Conversion.chaineSQL(contact.getAdresse())+","
                   + Conversion.chaineSQL(contact.getCodePostal())+","
                   + Conversion.chaineSQL(contact.getVille())+","
                   + contact.getCodeSecteur()+")" ;
           int codeRetour = accesBase.executeUpdate(insert);
           return codeRetour;
       }
        public int deleteContact(Contact contact) throws SQLException{
           String delete = "DELETE FROM CONTACT WHERE "+ contact.getNumero();
           int codeRetour = accesBase.executeUpdate(delete);
           return codeRetour; 
       }
    

//    public void majContact(Vector<Contact> contactModifier, Vector<Contact> contactInsere, Vector<Contact> contactSupprime) {
//        System.out.println("\nListe des contacts modifiés :\n");
//        if (contactModifier.size() == 0) {
//            System.out.println("Pas de contact modifié");
//        } else {
//            for (int i = 0; i < contactModifier.size(); i++) {
//                System.out.println(contactModifier.elementAt(i));
//            }
//
//            System.out.println("\nListe des contacts Inserés :\n");
//            if (contactInsere.size() == 0) {
//                System.out.println("Pas de contact inséré");
//            } else {
//                for (int i = 0; i < contactInsere.size(); i++) {
//                    System.out.println(contactInsere.elementAt(i));
//                }
//
//                System.out.println("\nListe des contacts supprimé :\n");
//                if (contactSupprime.size() == 0) {
//                    System.out.println("Pas de contact supprimé");
//                } else {
//                    for (int i = 0; i < contactSupprime.size(); i++) {
//                        System.out.println(contactSupprime.elementAt(i));
//                    }
//                }
//            }
//
//        }
//    }
}

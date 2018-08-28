
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import utilitairesMG.divers.Conversion;
import utilitairesMG.jdbc.AccesBase;
import utilitairesMG.jdbc.JeuResultat;


public class VersementDAO {

    private Versement versement;
    private JeuResultat jeuResultat;
    private AccesBase accesBase;

    VersementDAO(AccesBase accesBase) {
        this.accesBase = accesBase;
    }

    public Vector<Versement> lireListe(Contact contact) throws SQLException {
        Vector<Versement> listeVersements;

        String select = "SELECT * FROM VERSEMENT WHERE NUMERO_CONTACT =" + contact.getNumero();

        int nombreDeVersements;
        Vector ligneVersement;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeVersements = new Vector<Versement>();
        nombreDeVersements = (jeuResultat.getLignes()).size();
        for (i = 0; i < nombreDeVersements; i++) {
            ligneVersement = (Vector) ((jeuResultat.getLignes()).elementAt(i));
            versement = new Versement();
            versement.setNumero((Integer) ligneVersement.elementAt(0));
            versement.setDate((Date) ligneVersement.elementAt(1));
            versement.setMontant((BigDecimal) ligneVersement.elementAt(2));
            versement.setNumeroContact((Integer) ligneVersement.elementAt(3));
            listeVersements.addElement(versement);
        }
        return listeVersements;
    }
    public int updateVersement(Versement versement) throws SQLException{
           String update = "UPDATE VERSEMENT SET NUMERO = " + versement.getNumero()+ ","
                   +"DATE =" + Conversion.dateSQL(versement.getDate(),accesBase.getBase().getFormatDate())+","
                   +"MONTANT =" + versement.getMontant()+","
                   +"NUMERO_CONTACT = " + versement.getNumeroContact();
           int codeRetour = accesBase.executeUpdate(update);
           return codeRetour;
       }
        public int insertVersement(Versement versement) throws SQLException{
           String insert = "INSERT INTO VERSEMENT VALUES ( " + versement.getNumero()+ ","
                   + Conversion.dateSQL(versement.getDate(), accesBase.getBase().getFormatDate())+","
                   + versement.getMontant()+","
                   + versement.getNumeroContact()+")";
           int codeRetour = accesBase.executeUpdate(insert);
           return codeRetour;
       }
        public int deleteSecteur(Versement versement) throws SQLException{
           String delete = "DELETE FROM VERSEMENT WHERE "+versement.getNumero();
           int codeRetour = accesBase.executeUpdate(delete);
           return codeRetour;
       }

}

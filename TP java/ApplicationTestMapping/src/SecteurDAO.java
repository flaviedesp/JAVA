
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import utilitairesMG.divers.Conversion;
import utilitairesMG.jdbc.AccesBase;
import utilitairesMG.jdbc.JeuResultat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author afpa1797
 */
public class SecteurDAO {

    private Secteur secteur;
    private JeuResultat jeuResultat;
    private AccesBase accesBase;

    public SecteurDAO(AccesBase accesBase) {
        this.accesBase = accesBase;
    }

    public Secteur lireSecteur(Contact contact) throws SQLException {
        Vector<Secteur> listeSecteur;

        String select = "SELECT * FROM SECTEUR WHERE CODE=" + contact.getCodeSecteur();

        Vector ligneSecteur;
        jeuResultat = accesBase.executeQuery(select);

        listeSecteur = new Vector<Secteur>();  
        secteur = new Secteur();

        ligneSecteur = (Vector) ((jeuResultat.getLignes()).elementAt(0));
       // System.out.println(ligneSecteur);
        secteur.setCode((Integer) ligneSecteur.elementAt(0));
        secteur.setLibelle((String) ligneSecteur.elementAt(1));

        contact.setSecteur(secteur);
        return secteur;
    }
    public int updateSecteur(Secteur secteur) throws SQLException{
           String update = "UPDATE SECTEUR SET CODE = " + secteur.getCode()+ ","
                   +"LIBELLE =" + Conversion.chaineSQL(secteur.getLibelle());
           int codeRetour = accesBase.executeUpdate(update);
           return codeRetour;
       }
        public int insertSecteur(Secteur secteur) throws SQLException{
           String insert = "INSERT INTO SECTEUR VALUES ( " + secteur.getCode()+ ","
                   + Conversion.chaineSQL(secteur.getLibelle())+")";
           int codeRetour = accesBase.executeUpdate(insert);
           return codeRetour;
       }
        public int deleteSecteur(Secteur secteur) throws SQLException{
           String delete = "DELETE FROM SECTEUR WHERE "+secteur.getCode();
           int codeRetour = accesBase.executeUpdate(delete);
           return codeRetour;
       }
}

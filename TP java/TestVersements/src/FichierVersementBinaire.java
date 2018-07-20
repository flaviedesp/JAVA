
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import utilitairesMG.divers.*;

public class FichierVersementBinaire extends Fichier {

    private int tailleEnreg;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String mot;
    private Date date;

    public FichierVersementBinaire(File fichier, String mode, int tailleEnreg) throws IOException {
        super(fichier, mode, tailleEnreg);
    }

    public FichierVersementBinaire(String nom, String mode, int tailleEnreg) throws IOException {
        super(nom, mode, tailleEnreg);
    }

    public void rempliVersement(Versement versement, int numEnreg) throws IOException, ParseException {

        seekFichier(numEnreg);
        rempliVersement(versement);
    }

    public void rempliVersement(Versement versement) throws IOException {
        writeInt(versement.getNumero());
        mot = formatter.format(versement.getDate());
        writeString(mot, 11);
        writeDouble(versement.getMontant());
        writeInt(versement.getNumerocontact());
    }

    public void lireVersement(Versement versement) throws IOException {
        versement.setNumero(readInt());
        try {
            DateFr dateFr = new DateFr(readString(11));
            versement.setDate(dateFr.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FichierVersementBinaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        versement.setMontant(readDouble());
        versement.setNumeroContact(readInt());
    }
    public void lireVersement(Versement versement, int numEnreg) throws IOException
    {
        seekFichier(numEnreg);
        lireVersement(versement);
    }
//    public Vector<Versement> lireListe() throws IOException
//    {
//        Vector<Versement> listeVersement = new Vector<Versement>();
//        Versement versement;
//        
//        try
//        {
//            seekFichier(0);
//            
//            while(true)
//            {
//                versement = new Versement();
//                lireVersement(versement);
//                listeVersement.addElement(versement);                
//            }
//        }
//        catch(IOException e)
//        {
//            System.out.println("Indice incorrect");
//        }
//        return listeVersement;
//    }

   

}

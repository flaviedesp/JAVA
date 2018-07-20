
import java.io.*;
import utilitairesMG.divers.*;

public class FichierContactBinaireC extends Fichier {
    
       public FichierContactBinaireC(File fichier, String mode, int tailleEnreg) throws IOException {
        super(fichier, mode, tailleEnreg);
    }

    public FichierContactBinaireC(String nom, String mode, int tailleEnreg) throws IOException {
        super(nom, mode, tailleEnreg);
    }

    public void rempliContact(Contact contact) throws IOException {
        contact.setNumero(this.readIntC());
        contact.setNom(this.readString(21));
        contact.setAdresse(this.readString(51));
        contact.setCodePostal(this.readString(6));
        contact.setVille(this.readString(22));
        contact.setCodeSecteur(this.readIntC());
       
    }

}

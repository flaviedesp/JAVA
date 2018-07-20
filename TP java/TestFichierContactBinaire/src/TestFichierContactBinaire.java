
import java.io.*;
import utilitairesMG.divers.*;

public class TestFichierContactBinaire {

    public static void main(String argv[]) throws IOException {
        File dossier;
        File fichierEntree;
        FichierContactBinaireC entree;
        int nBytes = 108;
        Contact contact;

        /* OUVERTURE DU FICHIER */
        dossier = new File("R:\\JAVA\\Fichiers");
        fichierEntree = new File(dossier, "contacts.dat");
        try {
            entree = new FichierContactBinaireC(fichierEntree, "r", nBytes);

            /* BOUCLE DE SAISIE */
            try {
                while (true) {
                    contact = new Contact();
                    entree.rempliContact(contact);
                    System.out.println(contact);
                }
                /* FERMETURE ET ERREUR*/
            } catch (EOFException e) {
                System.out.println("Fin de l'impression");
                entree.close();
            } catch (IOException e) {
                System.out.println("Fichier vide");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}


import java.util.*;
import java.io.*;

public class CalculNote {

    public static void main(String argv[]) throws IOException {
        File dossier;
        File fichierEntre;
        File fichierSorti;
        BufferedReader entre;
        PrintWriter sorti;
        String ligne;
        String nom;
        int totalNotes;
        int compteurNotes;

        StringTokenizer token;

        dossier = new File("U:\\JAVA\\TPjava\\CalculNotes");
        fichierEntre = new File(dossier, "calculNotes.txt");
        fichierSorti = new File(dossier, "CalculNotesSorti.txt");

        try {
            entre = new BufferedReader(new InputStreamReader(new FileInputStream(fichierEntre), "Cp1252"));

            try {
                sorti = new PrintWriter(fichierSorti, "Cp1252");

                try {
                    ligne = entre.readLine();

                    while (ligne != null) {
                        token = new StringTokenizer(ligne, ";");
                        nom = token.nextToken();

                        totalNotes = 0;
                        compteurNotes = 0;

                        while (token.hasMoreTokens()) {
                            totalNotes += Integer.parseInt(token.nextToken());
                            compteurNotes++;
                        }
                        sorti.println("Le total des " + compteurNotes + " notes de " + nom + " est de : " + totalNotes);
                        ligne = entre.readLine();
                    }
                } finally {
                    sorti.close();
                }
            } finally {
                entre.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier " + fichierEntre.getName() + " est inconnu.");
        }
    }
}

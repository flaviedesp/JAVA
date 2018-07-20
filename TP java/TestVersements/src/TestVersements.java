
import java.io.*;
import java.util.*;
import java.text.*;
import utilitairesMG.divers.*;

public class TestVersements {

    public static void main(String argv[]) throws IOException, ParseException {
        File dossier;
        File fichierEntree;
        File fichierSortie;
        BufferedReader entree;
        FichierVersementBinaire sortie;
        String chaine;
        Versement versement;
        int nBytes = 27;
        StringTokenizer token;
        String mot;
        int n;
        Double d;
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Versement> liste = new ArrayList<Versement>();
        FichierVersementBinaire lecture;

        dossier = new File("U:\\JAVA\\TPjava\\TestVersements");
        fichierEntree = new File(dossier, "versements.txt");
        fichierSortie = new File(dossier, "versements.dat");

        try {
            entree = new BufferedReader(new InputStreamReader(new FileInputStream(fichierEntree), "Cp1252"));
            try {
                sortie = new FichierVersementBinaire(fichierSortie, "rw", nBytes);
                try {
                    chaine = entree.readLine();
                    
                    while (chaine != null) {
                        /* CREATION DU CONTACT DE LA LIGNE LUE*/
                        versement = new Versement();
                        
                        /* TRAITEMENT DE LA LIGNE LUE*/
                        token = new StringTokenizer(chaine, ";");

                        mot = token.nextToken();
                        n = Integer.parseInt(mot);
                        versement.setNumero(n);

                        mot = token.nextToken();
                        date = formatter.parse(mot);
                        versement.setDate(date);
                        
                        mot = token.nextToken();
                        d = Double.parseDouble(mot);
                        versement.setMontant(d);
                        
                        mot = token.nextToken();
                        n = Integer.parseInt(mot);
                        versement.setNumeroContact(n);
                        
                        /* AJOUT A LA LISTE */
                        liste.add(versement);
                        chaine = entree.readLine();                                             
                    }
                    /* TRIAGE*/
                    Collections.sort(liste);
                    for(int i = 0; i <liste.size(); i++)
                    {
                        sortie.rempliVersement(liste.get(i));
                       // System.out.println(liste.get(i));
                    }

                } finally {
                    sortie.close();
                }
            } finally {
                entree.close();
            }
           
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier " + fichierEntree.getName() + " est inconnu.");
        }
    }
}

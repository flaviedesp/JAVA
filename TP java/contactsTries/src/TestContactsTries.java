
import java.io.*;
import java.util.*;

public class TestContactsTries {

    public static void main(String argv[]) throws IOException {
        File dossier;
        File fichierEntree;
        File fichierSortie;
        BufferedReader entree;
        PrintWriter sortie;
        String ligne;
        
        Contact contact;
        
         
        dossier = new File("U:\\JAVA\\TPjava\\contactsTries");
        fichierEntree = new File(dossier, "contacts.txt");
        fichierSortie = new File(dossier, "contactsTries.txt");
        
        ArrayList<Contact> contactArray = new ArrayList<Contact>();
      
        try {
            entree = new BufferedReader(new InputStreamReader(new FileInputStream(fichierEntree), "Cp1252"));
            try {
                sortie = new PrintWriter(fichierSortie, "Cp1252");
                try {
                    ligne = entree.readLine();
                    
                    
                    while(ligne != null)
                    {                    
                        contactArray.add(new Contact(ligne));
                        Collections.sort(contactArray);
                        
                        ligne = entree.readLine();                                           
                    }
                    for(int i = 0; i< contactArray.size(); i++)
                    {
                        System.out.println(contactArray.get(i));
                        sortie.println(contactArray.get(i));
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

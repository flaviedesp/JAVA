import java.io.*;
import utilitairesMG.jdbc.*;
import utilitairesMG.divers.*;


public class ControleurServeur {
    public static void main(String[] argv) throws IOException{
        ServeurObjets serveur;
        BaseDeDonnees base;
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            base = new BaseDeDonnees("jdbc:sqlserver://mars;user=UTIL_BIP;" + "password = x; databasename=gnmi");
            base.setFormatDate("dd/MM/yyyy");
            
            serveur = new ServeurObjets(base);
            
            System.out.println("Démarrage du serveur d'objets...");
            serveur.start();
            
            System.out.println("\nTapez Entree pour l'arreter...\n");
            Clavier.readString();
            
            serveur.interrupt();
            System.out.println("Le serveur a été arreté...");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
}

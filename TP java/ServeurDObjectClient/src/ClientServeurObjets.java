import java.net.*;
import java.io.*;
import utilitairesMG.divers.*;


public class ClientServeurObjets {
    public static void main(String argv[]) throws IOException{
        Socket socketClient;
        ObjectInputStream entree;
        ObjectOutputStream sortie;
        
        String requete;
        Object reponse;
        
        try{
            System.out.println("\nRequete SQL :");
            requete = Clavier.readString();
            
            socketClient = new Socket("localhost", 8189);
            try{
                sortie = new ObjectOutputStream(socketClient.getOutputStream());
                entree = new ObjectInputStream(socketClient.getInputStream());
                sortie.writeObject(requete);
                
                reponse = entree.readObject();
                System.out.println(reponse);
                reponse = entree.readObject();
                System.out.println(reponse);
            }finally{
                socketClient.close();
            }
        }catch(ConnectException e){
            System.out.println("Connexion impossible : serveur indisponible");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}

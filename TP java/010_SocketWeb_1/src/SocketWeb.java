// ==========================================================================
// SocketWeb : Test de connexion au serveur WEB situe sur la machine locale
//             (adresse IP : 127.0.0.1) port : 8080. On envoie une requete 
//             HTTP de type GET pour lire le code de la page d'accueil du 
//             serveur.
// ==========================================================================

import java.net.*;
import java.io.*;

public class SocketWeb
{
    public static void main(String argv[])
    {
        Socket socketClient;
        BufferedReader entree;
        PrintWriter sortie;
        String ligne;

        try
        {
// --------------------------------------------------------------------------
// L'instanciation d'un objet Socket s'accompagne de l'envoi d'une requete
// de connexion. Il s'agit de l'envoi de l'adresse IP et du numero de port
// de l'application a atteindre.
// --------------------------------------------------------------------------
// Le port 8080 correspond au serveur JEE (GlassFish) installé localement.
// --------------------------------------------------------------------------
            socketClient = new Socket("94010-6101877", 8080);
            System.out.println(socketClient.getInetAddress());
            try
            {

// --------------------------------------------------------------------------
// Ouverture d'un flux d'ecriture pour envoyer des requetes au serveur
// --------------------------------------------------------------------------
                sortie = new PrintWriter(socketClient.getOutputStream());

// --------------------------------------------------------------------------
// Ouverture d'un flux de lecture pour recevoir les reponses du serveur
// --------------------------------------------------------------------------
                entree = new BufferedReader(
                    new InputStreamReader(socketClient.getInputStream()));

// --------------------------------------------------------------------------
// Envoi de requetes (simulation de HTTP).
// --------------------------------------------------------------------------
// Le flush() permet d'envoyer la requete...
// Si on ne le met pas, un buffer d'ecriture se remplit, et attend d'etre
// rempli pour partir automatiquement.
// --------------------------------------------------------------------------
                sortie.print("GET / HTTP/1.0\n\n");
                sortie.flush();

// --------------------------------------------------------------------------
// Lecture de la reponse du serveur : il s'agit de l'ecran d'accueil de
// GlssFish
// --------------------------------------------------------------------------
                System.out.println("\nFichier d'accueil :\n");

                ligne = entree.readLine();

                while (ligne != null)
                {
                    System.out.println(ligne);
                    ligne = entree.readLine();
                }
            }
            finally
            {
                socketClient.close();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

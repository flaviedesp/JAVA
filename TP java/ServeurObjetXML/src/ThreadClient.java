// ==========================================================================
// Classe ThreadClient  
// --------------------------------------------------------------------------
// Thread client. Processus de dialogue avec un client.
// ==========================================================================

import java.net.*;
import java.io.*;
import java.sql.*;
import utilitairesMG.jdbc.*;

public class ThreadClient extends Thread {

// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// socketServeur : reference d'une socket du serveur vers le client.
//                 Cette socket est ouverte par le thread maitre (serveur) et
//                 transmise au constructeur.
//
// accesBase     : acees du thread a la base de donnees.
// --------------------------------------------------------------------------
    private Socket socketServeur;
    private AccesBase accesBase;

// ==========================================================================
// Constructeur
// ==========================================================================
    public ThreadClient(Socket socketServeur, BaseDeDonnees base) {
        this.socketServeur = socketServeur;
        this.accesBase = new AccesBase(base);
    }

// ==========================================================================
// Traitement de chaque client. Cette methode est commune a tous les objets
// de type ThreadClient crees par le thread Serveur. Mais les proprietes et
// les parametres de methodes sont dupliques (on peut le mettre en evidence
// en affichant les references d'entree et sortie ci-dessous). Il n'y a pas
// de probleme de melange de donnees (pas de necessite de synchronisation).
// ==========================================================================
    public void run() {
        PrintWriter sortie;
        BufferedReader entree;
        String texteRequete;
        String str;
        JeuResultatXML jeuResultatXML;
        int nombreLignesModifiees = 0;

        try {

// --------------------------------------------------------------------------
// REMARQUE IMPORTANTE :
// --------------------------------------------------------------------------
// Il faut mettre le ObjectOutputStream avant le ObjectInputStream. En effet,
// le new ObjectInputStream() attend que le ObjectOutputStream du client soit
// fait. Si par hasard le client ecrit son new ObjectInputStream() avant son
// new ObjectOutputStream(), les deux applications vont se bloquer
// mutuellement !
// --------------------------------------------------------------------------
            try {
                sortie = new PrintWriter(
                        new OutputStreamWriter(
                                socketServeur.getOutputStream(), "utf-8"), true);

                entree = new BufferedReader(
                        new InputStreamReader(
                                socketServeur.getInputStream(), "utf-8"));

// --------------------------------------------------------------------------
// Lecture de la requete envoyee par le client :
// --------------------------------------------------------------------------
                texteRequete = (String) entree.readLine();
                Controleur.traiterTexte("Client "
                        + socketServeur.getInetAddress()
                        + "  : "
                        + texteRequete);

// --------------------------------------------------------------------------
// Ouverture de la connexion
// --------------------------------------------------------------------------
                try {
                    System.out.println("Connexion");
                    accesBase.getConnection();
                    System.out.println("Connexion");

// --------------------------------------------------------------------------
// Type de requete : est-ce un select ?
// --------------------------------------------------------------------------
                    try {
                        texteRequete = texteRequete.trim();

// --------------------------------------------------------------------------
// Execution de la requete :
// --------------------------------------------------------------------------
                        if ((texteRequete.length() >= 6)
                                && (texteRequete.substring(0, 6).
                                compareToIgnoreCase("SELECT") == 0)) {
                            try {
                                jeuResultatXML = accesBase.executeQueryXML(texteRequete);
                                str=jeuResultatXML.getResultatXML();
                                //sortie.write(1);
                                //sortie.println(jeuResultatXML);
                                System.out.println(str);
                                sortie.println(str);
                            } catch (SQLException e) {
                                sortie.println("<?xml version=\"1.0\" encoding=\"utf-8\">\n\n"
                                        + "<!DOCTYPE ERREUR [\n"
                                        + "  <ELEMENT ERREUR (#PCDATA)>\n"
                                        + "]>\n\n"
                                        + "<ERREUR>\n"
                                        + "   " + e.getMessage() + "\n"
                                        + "</ERREUR>");
                            }
                        } else {
                            
                                nombreLignesModifiees
                                        = accesBase.executeUpdate(texteRequete);

// --------------------------------------------------------------------------
// Execution reussie : envoi des resultats au client
// --------------------------------------------------------------------------
// On envoie successivement :
//    le code 2
//    le nombre de lignes modifiees
// --------------------------------------------------------------------------
                                //sortie.write(2);
                                //sortie.println(nombreLignesModifiees);
                            
                                sortie.println("<?xml version=\"1.0\" encoding=\"utf-8\">\n\n"
                                        + "<!DOCTYPE MODIF [\n"
                                        + "  <ELEMENT MODIF (#PCDATA)>\n"
                                        + "]>\n\n"
                                        + "<MODIF>\n"
                                        + "   Nombre de ligne modifiée : " + nombreLignesModifiees + "\n"
                                        + "</MODIF>");
                            
                        }
                    } finally {
                        accesBase.closeConnection();
                    }
                } // --------------------------------------------------------------------------
                // Erreur d'execution de la requete : envoi des resultats au client
                // --------------------------------------------------------------------------
                // On envoie successivement :
                //    0
                //    le message d'erreur genere par la BDD
                // --------------------------------------------------------------------------
                catch (SQLException sqlex) {
                    //sortie.write(0);
                    sortie.println(sqlex.getMessage());
                }
            } // --------------------------------------------------------------------------
            // Fermeture des flux et du socket client :
            // --------------------------------------------------------------------------
            finally {
                socketServeur.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

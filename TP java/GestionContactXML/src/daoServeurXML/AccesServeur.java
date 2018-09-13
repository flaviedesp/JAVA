// ==========================================================================
// Classe AccesServeur
// --------------------------------------------------------------------------
// Un objet AccesBase permet d'obtenir un acc�s au ServeurObjets.
// ==========================================================================
package daoServeurXML;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import utilitairesMG.jdbc.*;
import utilitairesMG.divers.*;


public class AccesServeur {

    private PriseServeur prise;
    private Socket socketClient;
    private InputSource sourceXml;
    ;
    private PrintWriter sortie;
    private InputStreamReader entree;   

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public AccesServeur(PriseServeur prise) {
        this.prise = prise;
    }

    public PriseServeur getPrise() {
        return prise;
    }

// --------------------------------------------------------------------------
// Methode d'ouverture d'une connexion (socket) au ServeurObjets
// --------------------------------------------------------------------------
    public Socket getConnection() throws IOException {
        socketClient = new Socket(getPrise().getNomMachine(),
                getPrise().getNumeroPort());

        sortie = new PrintWriter(
                new OutputStreamWriter(
                        socketClient.getOutputStream(), "utf-8"), true);

        entree = new InputStreamReader(
                socketClient.getInputStream(), "utf-8");

        sourceXml = new InputSource(entree);
        return socketClient;
    }

// --------------------------------------------------------------------------
// Methode de fermeture de la connexion
// --------------------------------------------------------------------------
    public void closeConnection() throws IOException {
        if ((socketClient != null) && (!socketClient.isClosed())) {
            socketClient.close();
        }
    }

// --------------------------------------------------------------------------
// executeQuery (SELECT)
// --------------------------------------------------------------------------
// Cette methode retourne le jeu de resultats obtenu par le Select
// --------------------------------------------------------------------------
    public JeuResultat executeQuery(String requete)
            throws ParserConfigurationException, SAXException, IOException {

        JeuResultat jeuResultat;
        Vector<Colonne> colonnes;
        Vector<Vector<Object>> lignes;

        SAXParserFactory saxeUsineFactory;
        SAXParser parseurXML;
        EcouteurSaxXml ecouteur;

        saxeUsineFactory = SAXParserFactory.newInstance();
        parseurXML = saxeUsineFactory.newSAXParser();
        ecouteur = new EcouteurSaxXml();

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
        if (requete.compareTo("") == 0) {
            throw new SAXException("requete vide");
        }

// --------------------------------------------------------------------------
// Ouverture de la connexion avec le serveur JDBC.
// --------------------------------------------------------------------------
// Il faut ouvrir (et fermer) la connexion a chaque appel (executeQuery ou
// executeUpdate), a cause de la conception du serveur d'objets...
// --------------------------------------------------------------------------
// En effet, dans le serveur, le thread client ouvre une socket a la
// reception de la requete (accept), exécute le requete, envoie le resultat,
// et FERME la socket.
// --------------------------------------------------------------------------
        getConnection();

        try {

// --------------------------------------------------------------------------
// Envoi de la requete vers le serveur.
// --------------------------------------------------------------------------
            sortie.println(requete);

            parseurXML.parse(sourceXml, ecouteur);

            if (ecouteur.getErreur() == true) {
                throw new SAXException(ecouteur.getTexteErreur());
            } else {
                colonnes = ecouteur.getColonnes();
                lignes = ecouteur.getLignes();

                jeuResultat = new JeuResultat();
                jeuResultat.setColonnes(colonnes);
                jeuResultat.setLignes(lignes);
            }
        } finally {
            closeConnection();
        }
        return jeuResultat;
    }

// --------------------------------------------------------------------------
// executeUpdate (INSERT, DELETE, UPDATE)
// --------------------------------------------------------------------------
// Cette methode retourne le nombre de lignes concernees par la requete
// --------------------------------------------------------------------------
    public Integer executeUpdate(String requete)
            throws ParserConfigurationException, SAXException, IOException {
        
        Integer nombreLigne;
        SAXParserFactory saxeUsineFactory;
        SAXParser parseurXML;
        EcouteurSaxUpdate ecouteur;
        
        saxeUsineFactory = SAXParserFactory.newInstance();
        parseurXML = saxeUsineFactory.newSAXParser();
        ecouteur = new EcouteurSaxUpdate();

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
        if (requete.compareTo("") == 0) {
            throw new SAXException("Requete vide");
        }

// --------------------------------------------------------------------------
// Ouverture de la connexion avec le serveur JDBC.
// --------------------------------------------------------------------------
        getConnection();

        try {

// --------------------------------------------------------------------------
// Envoi de la requete vers le serveur.
// --------------------------------------------------------------------------
            sortie.println(requete);

            parseurXML.parse(sourceXml, ecouteur);

            if (ecouteur.getErreur() == true) {                
                throw new SAXException(ecouteur.getTexteErreur());
            } else {
                nombreLigne = ecouteur.getNombreLignes();
            }
        } finally {
            closeConnection();
        }
        return nombreLigne;
    }

}

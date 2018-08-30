
import java.io.*;
import java.net.*;
import utilitairesMG.jdbc.*;

public class AccesServeur {

    private static Socket socketClient;
    private static ObjectInputStream entree;
    private static ObjectOutputStream sortie;

    private Integer reponse;
    private JeuResultat jeuResultat;
    private int nombreModif;
    private static PriseServeur priseServeur;

    public AccesServeur(PriseServeur priseServeur) {
        this.priseServeur = priseServeur;
    }

    public PriseServeur getPriseServeur() {
        return priseServeur;
    }

    public static Socket getConnection() throws IOException {

        socketClient = new Socket(priseServeur.getNomMachine(), priseServeur.getNumeroPort());
        sortie = new ObjectOutputStream(socketClient.getOutputStream());
        entree = new ObjectInputStream(socketClient.getInputStream());

        return socketClient;
    }

    public static void closeConnection() throws IOException {
        if ((socketClient != null) && (!socketClient.isClosed())) {
            socketClient.close();
        }
    }

    public JeuResultat executeQuery(String select) throws IOException, ClassNotFoundException {
        if (select.compareTo("") == 0) {
            throw new IOException("Requete vide");
        }
        getConnection();
        try {
            sortie.writeObject(select);

            reponse = (Integer) entree.readObject();

            if (reponse == 0) {
                throw new IOException((String) entree.readObject());
            } else {
                jeuResultat = (JeuResultat) entree.readObject();
            }
            return jeuResultat;

        } finally {
            closeConnection();
        }
    }

    public Integer executeUpdate(String requete) throws IOException, ClassNotFoundException {

        if (requete.compareTo("") == 0) {
            throw new IOException("Requete vide");
        }
        getConnection();
        try {
            sortie.writeObject(requete);

            reponse = (Integer) entree.readObject();
            if (reponse == 0) {
                throw new IOException((String) entree.readObject());
            } else {
                System.out.println(reponse);
                nombreModif = (Integer) entree.readObject();
            }
            return nombreModif;
            
        } finally {
            closeConnection();
        }

    }

    public PriseServeur getServeur() {
        return priseServeur;
    }
}

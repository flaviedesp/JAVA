
import java.net.*;
import java.io.*;
import java.sql.SQLException;
import utilitairesMG.jdbc.*;

class ThreadClient extends Thread {

    private Socket socketServeur;
    private AccesBase accesBase;
    private JeuResultat jeuResultat;
    private int rowCount;

    public ThreadClient(Socket socketServeur, AccesBase base) {
        this.socketServeur = socketServeur;
        this.accesBase = base;
    }

    public void run() {
        ObjectInputStream entree;
        ObjectOutputStream sortie = null;

        String ligne;
        
        try {
            try {
                sortie = new ObjectOutputStream(socketServeur.getOutputStream());
                entree = new ObjectInputStream(socketServeur.getInputStream());

                ligne = (String) entree.readObject();
                ligne = ligne.toUpperCase();
                ligne = ligne.trim();
                //System.out.println(socketServeur.getInetAddress());

                if (ligne.contains("SELECT")) {
                    executeRequete(ligne);
                    sortie.writeObject(1);
                    //sortie.writeObject(jeuResultat);
                    sortie.writeObject(jeuResultat.getLignes());

                } else {
                    executeUpdate(ligne);
                    sortie.writeObject(2);
                    sortie.writeObject(rowCount);
                }
                System.out.println("Client " + socketServeur.getLocalAddress() + "  : " + ligne);
            } catch (ClassNotFoundException e) {

                sortie.writeObject(0);
                sortie.writeObject(e.getMessage());
            } finally {
                socketServeur.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public void executeRequete(String requete) {

        try {
            accesBase.getConnection();
            try {
                jeuResultat = accesBase.executeQuery(requete);
            } catch (SQLException e) {
                System.out.println("Connection impossible");
            } finally {
                accesBase.closeConnection();
            }
        } catch (SQLException e) {
            System.out.println("Connection a la base de donnée impossible");
        }
    }

    public void executeUpdate(String ligne) {
        String modif;

        try {
            accesBase.getConnection();
            try {
                rowCount = accesBase.executeUpdate(ligne);
            } catch (SQLException e) {
                System.out.println("Connection impossible");
            } finally {
                accesBase.closeConnection();
            }
        } catch (SQLException e) {
            System.out.println("Connection a la base de donnée impossible");
        }
    }
}

// ==========================================================================
// Projet serveurMulti : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// ServeurMulti : Serveur (thread maitre de l'application).
// ==========================================================================

import java.net.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class ServeurObjets extends Thread {

    private BaseDeDonnees base;

    public ServeurObjets(BaseDeDonnees base) {
        this.base = base;
    }

    public void run() {
        ServerSocket serveur;
        boolean actif;
        Socket socketServeur;
        Thread threadClient;
        AccesBase accesBase
                ;
        
        accesBase = new AccesBase(base);
        try {
            serveur = new ServerSocket(8189);
            try {
                serveur.setSoTimeout(10);
                actif = true;

// --------------------------------------------------------------------------
// Le serveur est actif jusqu'a ce que le programme Principal envoie un
// ordre d'interruption (interrupt()). Dans ce cas, la methode interrupted()
// renvoie true. Le programme ne fonctionne que parce qu'on a limite le
// temps d'attente du accept() par la methode setSoTimeout(10). Sinon, le 
// programme attend indefiniment qu'un client se connecte...
// --------------------------------------------------------------------------
                while (actif) {
                    try {
                        socketServeur = serveur.accept();

                        threadClient = new ThreadClient(socketServeur, accesBase);
                        threadClient.start();
                    } catch (SocketTimeoutException e) {
                        if (interrupted()) {
                            actif = false;                            
                        }
                    }
                }
            } finally {
                serveur.close();                
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

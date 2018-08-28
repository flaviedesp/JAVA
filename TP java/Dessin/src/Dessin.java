/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afpa1797
 */
public class Dessin {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                Fenetre fenetre = new Fenetre("Trace de la souris dans un panneau");
            }
        }
        );
    }

}

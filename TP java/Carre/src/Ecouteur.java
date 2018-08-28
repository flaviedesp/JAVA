/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
/**
 *
 * @author afpa1797
 */
public class Ecouteur extends WindowAdapter{
    
        public void windowOpened(WindowEvent e) {
        System.out.println("windowOpened : " + e.hashCode());
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing : " + e.hashCode());
        System.exit(0);//permet que quand on clique sur la croix le programme s'arrete
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed : " + e.hashCode());
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified : " + e.hashCode());
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified : " + e.hashCode());
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated : " + e.hashCode());
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated : " + e.hashCode());
    }
}

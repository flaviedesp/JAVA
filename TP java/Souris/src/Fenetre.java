/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author afpa1797
 */
public class Fenetre extends JFrame implements MouseMotionListener, MouseListener, MouseWheelListener {

    private int depX = 300;
    private int depY = 300;
    private int x = 100;
    private int y = 100;
    private boolean titre = true;

    public Fenetre(String titre) {
        super(titre);
        this.setBounds(x, y, depX, depY); //permet de determiné l'emplacement x, y et la taille hauteur, largeur
        addWindowListener(new Ecouteur()); //permet de mettre en place les ecouteurs
        addMouseMotionListener(this);//permet d'integrer les mouvements de la souris
        addMouseListener(this);//permet d'integrer les actions de la souris
        addMouseWheelListener(this);//permet d'integrer les actions du scroll de la souris
        setVisible(true);//permet de mettre la fenetre en visible        

    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        // System.out.println("mousePressed : " + x + ", " + y);

    }

    public void mouseDragged(MouseEvent e) {
        // System.out.println("mouseDragged : " + x + ", " + y);
        setLocation(getLocation().x - x + e.getX(), getLocation().y - y + e.getY());
        //getX() et getY() sont en fonction de la position de la souris
        //en enlevant x et y , on fait en sorte que le coin superieur gauche de la 
        //fenetre ne se place pas au niveau du curseur. comme ça on peux cliquer n'inporte où 
        // dans la fenetre
    }

    public void mouseMoved(MouseEvent e) {
//        x = e.getX();
//        y = e.getY();
//        System.out.println("mouseMoved : " + x + ", " + y);
    }

    public void mouseClicked(MouseEvent e) {
//        x = e.getX();
//        y = e.getY();
//        System.out.println("mouseClicked : " + x + ", " + y);
        if (titre == false) {
            setTitle("Déplacement vertical");//Permet de modifier le titre
            titre = true;
        } else {
            setTitle("Déplacement horizontal");
            titre = false;
        }
    }

    public void mouseReleased(MouseEvent e) {
//        x = e.getX();
//        y = e.getY();
        // System.out.println("mouseReleased : " + +x + ", " + y);
    }

    public void mouseEntered(MouseEvent e) {
//        x = e.getX();
//        y = e.getY();
        //   System.out.println("mouseEntered : " + x + ", " + y);
    }

    public void mouseExited(MouseEvent e) {
//        x = e.getX();
//        y = e.getY();
        //   System.out.println("mouseExited : " + x + ", " + y);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        int scroll = e.getWheelRotation()*20;

        if (titre == true) {
            setLocation(getLocation().x, getLocation().y + scroll);

        } else {
            setLocation(getLocation().x + scroll, getLocation().y);
        }
    }

}

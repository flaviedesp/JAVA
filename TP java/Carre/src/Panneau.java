
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import utilitairesMG.graphique.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author afpa1797
 */
public class Panneau extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

    private Point coordonneesRect;
    private ArrayList<Carre> liste = new ArrayList();
    private int taille = 12;
    private Color carreCouleur = Color.BLACK;
    private Carre carre;

    public Panneau() {
        addMouseListener(this);
    }

    public void setList() {
        liste.clear();
        coordonneesRect = null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (coordonneesRect != null) {

            for (int i = 0; i < liste.size(); i++) {
                carre = liste.get(i);
                g.setColor(carre.getColor());
                g.fillRect(carre.x, carre.y, carre.width, carre.height);
            }
        }
    }

    public void setCarreCouleur(Color carreCouleur) {
        this.carreCouleur = carreCouleur;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        coordonneesRect = e.getPoint();
        liste.add(new Carre(e.getX(), e.getY(), taille, carreCouleur));
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
    }

    public void effacer() {
        liste.clear();
        repaint();
    }
}

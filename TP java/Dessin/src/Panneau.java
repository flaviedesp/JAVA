
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class Panneau extends JPanel implements MouseListener {

    private Point coordonneesRect;
    private ArrayList<Point> liste = new ArrayList();

    public Panneau() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (coordonneesRect != null) {
            g.fillOval(coordonneesRect.x, coordonneesRect.y, 8, 8);
            for (int i = 0; i < liste.size(); i++) {
                g.fillOval(liste.get(i).x, liste.get(i).y, 8, 8);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        coordonneesRect = e.getPoint();
        liste.add(coordonneesRect);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}

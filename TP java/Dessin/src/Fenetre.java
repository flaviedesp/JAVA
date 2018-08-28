/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import utilitairesMG.graphique.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author afpa1797
 */
public class Fenetre extends JFrame {

    private JPanel panneauFond;
    private Panneau panneauBlanc;
    private Panneau panneauNoir;
    
    public Fenetre(String s) {
        super(s);
        addWindowListener(new Ecouteur());

        panneauFond = new JPanel();
        panneauFond.setLayout(new GridLayout(1, 2));
        panneauFond.setPreferredSize(new Dimension(800, 300));

        panneauBlanc = new Panneau();
        panneauBlanc.setBackground(Color.WHITE);
        panneauBlanc.setForeground(Color.BLACK);
        panneauBlanc.setPreferredSize(new Dimension(400, 300));

        panneauNoir = new Panneau();
        panneauNoir.setBackground(Color.BLACK);
        panneauNoir.setForeground(Color.WHITE);
        panneauNoir.setPreferredSize(new Dimension(400, 300));

        panneauFond.add(panneauBlanc);
        panneauFond.add(panneauNoir);

        getContentPane().add(panneauFond);
        //add(panneauFond);
        pack();
        setVisible(true);

    }   

}

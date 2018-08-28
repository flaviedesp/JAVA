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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author afpa1797
 */
public class Fenetre extends JFrame implements ActionListener {

    private JPanel panneauFond;
    private JOptionPane fenetreAide;
    private JPanel panneauAideFond;
    private Panneau panneauColore;
    private JMenuBar menuBar;
    private JMenu jeu, couleur;
    private JMenuItem effacer, aide;
    private JCheckBoxMenuItem rouge, bleu, vert;
    private int couleurRouge, couleurVerte, couleurBleue ;

    public Fenetre(String s) {
        super(s);
        addWindowListener(new Ecouteur());

        panneauFond = new JPanel();
        panneauFond.setLayout(new GridLayout(1, 2));
        panneauFond.setPreferredSize(new Dimension(800, 300));

        panneauColore = new Panneau();
        panneauColore.setBackground(Color.WHITE);
        panneauColore.setForeground(Color.BLACK);
        panneauColore.setPreferredSize(new Dimension(800, 300));

        menuBar = new JMenuBar();
        jeu = new JMenu("Jeu");
        couleur = new JMenu("Couleur");
        effacer = new JMenuItem("Effacer");
        aide = new JMenuItem("Aide");
        rouge = new JCheckBoxMenuItem("Rouge");
        vert = new JCheckBoxMenuItem("Vert");
        bleu = new JCheckBoxMenuItem("Bleu");

        rouge.addActionListener(this);
        vert.addActionListener(this);
        bleu.addActionListener(this);
        effacer.addActionListener(this);
        aide.addActionListener(this);
        panneauFond.addMouseWheelListener(new Panneau());

        jeu.add(effacer);
        jeu.add(aide);

        couleur.add(rouge);
        couleur.add(vert);
        couleur.add(bleu);

        menuBar.add(jeu);
        menuBar.add(couleur);

        setJMenuBar(menuBar);

        panneauFond.add(panneauColore);

        getContentPane().add(panneauFond);
        //add(panneauFond);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {        

        if (e.getSource() == effacer) {
            panneauColore.effacer();
        } else if (e.getSource() == aide) {
            fenetreAide = new JOptionPane();
            fenetreAide.showMessageDialog(this, "Clic gauche : ajout et déplacement\n" + "Clic droit : suppression\n" + "Roulette : dimension carré",
                    "Fonctionnement du jeu", JOptionPane.INFORMATION_MESSAGE);
            //setVisible(true);
            couleurRouge = 0;
            
            
        } else if (rouge.isSelected() == true) {
            couleurRouge = 255;
            couleurVerte = 0;
            couleurBleue = 0;
        } else if (vert.isSelected() == true) {
            couleurVerte = 255;
            couleurBleue = 0;
            couleurRouge = 0;
        } else if (bleu.isSelected() == true) {
            couleurBleue = 255;
            couleurVerte = 0;
            couleurRouge = 0;
        }
        panneauColore.setCarreCouleur(new Color(couleurRouge, couleurVerte, couleurBleue));
    }

}

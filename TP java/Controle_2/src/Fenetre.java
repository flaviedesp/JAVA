
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;
import java.lang.*;
import javax.imageio.ImageIO;
import utilitairesMG.graphique.FlowLayoutMG;

public class Fenetre extends JFrame implements ActionListener, SpinnerModel, LayoutManager {

    private JPanel panneauFond;
    private JPanel panneauHaut;
    private JPanel panneauBas;
    private JPanel panneauSpinner;
    private JPanel panneauExecute;
    private JPanel panneauCase;
    private JPanel panneauEtat;
    private JScrollPane defileur;
    private JScrollPane defileurText;
    private JLabel labelSpinner;
    private JSpinner spinner;
    private JButton execute;
    private JButton etat;
    private JCheckBox nouvelleCase;
    private int numeroCase = 1;
    private Component[] liste;
    private TextArea text;
    private Panneau monPanneau;

    public Fenetre(String s, String imageFond) {
        super(s);
        addWindowListener(new Ecouteur());


        /*-----------------------------------------------*/
 /*--------------Panneau de fond------------------*/
 /*-----------------------------------------------*/
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        //panneauFond.setBackground(Color.pink);
        panneauFond.setPreferredSize(new Dimension(450, 400));
        monPanneau = new Panneau(imageFond);
        getContentPane().add(panneauFond);

        panneauHaut = new JPanel();
        panneauHaut.setLayout(new FlowLayout(FlowLayout.CENTER));
        panneauHaut.setPreferredSize(new Dimension(400, 100));
        panneauHaut.setOpaque(false);

        panneauBas = new JPanel();
        panneauBas.setLayout(new FlowLayout(FlowLayout.CENTER));
        panneauBas.setPreferredSize(new Dimension(400, 150));
        panneauBas.setOpaque(false);

        /*-----------------------------------------------*/
 /*--------------Panneau gestion du Spinner-------*/
 /*-----------------------------------------------*/
        panneauSpinner = new JPanel();
        panneauSpinner.setLayout(new FlowLayout(FlowLayout.CENTER));
        panneauSpinner.setPreferredSize(new Dimension(400, 50));
        panneauSpinner.setBorder(BorderFactory.createLineBorder(Color.pink));
        panneauSpinner.setOpaque(false);

        labelSpinner = new JLabel("Nombre de JCheckBox à créer : ");
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        ((NumberFormatter) ((JFormattedTextField) ((DefaultEditor) spinner.getEditor()).getTextField()).getFormatter()).setAllowsInvalid(false);

        /*----------------------------------------------------------------------*/
 /*--------------ajoute dse fontions au panneau Spinner------------------*/
 /*----------------------------------------------------------------------*/
        panneauSpinner.add(labelSpinner);
        panneauSpinner.add(spinner);

        /*--------------------------------------------------------------*/
 /*--------------Panneau pour le bouton Execute------------------*/
 /*--------------------------------------------------------------*/
        panneauExecute = new JPanel();
        panneauExecute.setLayout(new FlowLayout(FlowLayout.CENTER));
        panneauExecute.setPreferredSize(new Dimension(400, 40));
        panneauExecute.setOpaque(false);

        execute = new JButton("EXECUTER");
        execute.addActionListener(this);

        panneauExecute.add(execute);

        /*-------------------------------------------------*/
 /*--------------Panneau des cases------------------*/
 /*-------------------------------------------------*/
        panneauCase = new JPanel();
        panneauCase.setLayout(new FlowLayoutMG());
        //panneauCase.setPreferredSize(new Dimension(400, 50));
        panneauCase.setBorder(BorderFactory.createLineBorder(Color.pink));
        panneauCase.setOpaque(false);
        defileur = new JScrollPane(panneauCase);
        defileur.setPreferredSize(new Dimension(400, 100));

        /*----------------------------------------------------------*/
 /*--------------panneau pour le bouton etat-----------------*/
 /*----------------------------------------------------------*/
        panneauEtat = new JPanel();
        panneauEtat.setLayout(new FlowLayout(FlowLayout.CENTER));
        panneauEtat.setPreferredSize(new Dimension(400, 40));
        panneauEtat.setOpaque(false);

        etat = new JButton("ETAT");
        etat.addActionListener(this);

        panneauEtat.add(etat);

        /*----------------------------------------------------------*/
 /*--------------panneau pour l'affichage du texte-----------------*/
 /*----------------------------------------------------------*/
//        panneauText = new JPanel();
//        panneauText.setLayout(new FlowLayoutMG());
        text = new TextArea();
        text.setPreferredSize(new Dimension(400, 100));

        //panneauText.add(text);
        defileurText = new JScrollPane(text);
        //defileurText.setPreferredSize(new Dimension(350, 100));
        //text.setBounds(0,0,0,0);

        /*----------------------------------------------------------------------*/
 /*--------------Ajout dse panneau specique au panneaux generaux---------*/
 /*----------------------------------------------------------------------*/
        panneauHaut.add(panneauSpinner, BorderLayout.NORTH);
        panneauHaut.add(panneauExecute);
        panneauFond.add(panneauHaut, BorderLayout.NORTH);
        panneauBas.add(defileur, BorderLayout.NORTH);
        panneauBas.add(panneauEtat);
        panneauBas.add(defileurText, BorderLayout.SOUTH);
        panneauFond.add(panneauBas);

        add(panneauFond);

        pack();
        setLocationRelativeTo(null);
        text.setVisible(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        int valeurSpinner = Integer.parseInt(spinner.getValue().toString());
        if (source == execute) {

            panneauCase.removeAll();

            for (int i = 1; i < valeurSpinner + 1; i++) {
                nouvelleCase = new JCheckBox("Case " + numeroCase);
                panneauCase.add(nouvelleCase);
//nouvelleCase.addActionListener(this);
                //panneauCase.add(nouvelleCase);
                numeroCase++;
            }
            liste = panneauCase.getComponents();
            panneauCase.validate();
            panneauCase.revalidate();
            panneauCase.repaint();
        }

        if (e.getSource() == etat) {

            text.setText("Selection des cases :\n\n");
            for (int j = 0; j < liste.length; j++) {

                if (liste[j] instanceof JCheckBox) {
                    JCheckBox caseTest = (JCheckBox) liste[j];

                    if (caseTest.isSelected() == true) {
                        System.out.println("Case " + (j + 1) + " sélectionnée");
                        text.append("Case " + (j + 1) + " sélectionnée\n");

                    } else {
                        System.out.println("Case " + (j + 1) + " non sélectionnée");
                        text.append("Case " + (j + 1) + " non sélectionnée\n");
                    }
                }
            }

        }

    }

    @Override
    public Object getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getNextValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getPreviousValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void layoutContainer(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

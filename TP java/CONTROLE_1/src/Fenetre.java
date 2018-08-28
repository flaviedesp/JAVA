
import javax.swing.*;
import java.awt.event.*;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
import java.awt.*;

public class Fenetre extends JFrame implements ActionListener{
    
    private JPanel panneauFond;
    private JPanel panneauHaut;
    private JCheckBox check1;
    private JCheckBox check2;
    private JPanel panneauBas;
    private JLabel text1;
    private JLabel text2;
    private int largeur = 400;
    private int hauteur = 80; 
    
    private JScrollPane defileur;
    
    public Fenetre(String s){
        super(s);
        addWindowListener(new Ecouteur());
                
        panneauFond = new JPanel();
        panneauFond.setLayout(new GridLayout(2,1));  
        
        
        panneauHaut = new JPanel();
        panneauHaut.setLayout(new FlowLayout(FlowLayout.LEFT));
        panneauHaut.setBackground(Color.pink);
        panneauBas = new JPanel();
        panneauBas.setLayout(new FlowLayout(FlowLayout.LEFT));
        panneauBas.setBackground(Color.pink);
        
        panneauHaut.setPreferredSize(new Dimension(largeur, hauteur));
        panneauBas.setPreferredSize(new Dimension(largeur, hauteur));
        
        check1 = new JCheckBox("Case 1");
        check1.setBackground(Color.WHITE);
        //check1.setOpaque(false);
        check2 = new JCheckBox("Case 2");
        check2.setBackground(Color.WHITE);
        //check2.setOpaque(false);
        
        check1.addActionListener(this);
        check2.addActionListener(this);
        
        panneauHaut.add(check1);
        panneauBas.add(check2);
        
        text1 = new JLabel("Case 1 non sélectionnée");
        text1.setToolTipText("Etat de la première case");
        text2 = new JLabel("Case 2 non sélectionnée");
        text2.setToolTipText("Etat de la seconde case");
        
        panneauHaut.add(text1);
        panneauBas.add(text2);
        
        panneauFond.add(panneauHaut);
        panneauFond.add(panneauBas);
        
        defileur = new JScrollPane(panneauFond);
        
        add(defileur);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);      
        
    }
   
    public void actionPerformed(ActionEvent e) {
                
        if(check1.isSelected()== true){
            text1.setText("Case 1 cochée");
            text1.setForeground(Color.red);
            check1.setForeground(Color.red);
            
        }else{
            text1.setText("Case 1 non sélectionnée");
            text1.setForeground(Color.BLACK);
            check1.setForeground(Color.BLACK);
        }
        if(check2.isSelected()== true){
            text2.setText("Case 2 cochée");
            text2.setForeground(Color.red);
            check2.setForeground(Color.red);
        }else{
            text2.setText("Case 2 non sélectionnée");
            text2.setForeground(Color.BLACK);
            check2.setForeground(Color.BLACK);
        }
    }
 
}

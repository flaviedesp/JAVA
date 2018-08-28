
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;


public class Fenetre extends JFrame{
    private JPanel panneauFond;
    private JPanel panneauHaut;
    private JLabel message;
    private JLabel titre;
    private JTextField texteRequete;
    private JTable table;
    
    public Fenetre(String s){
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        
        panneauHaut = new JPanel();
        panneauHaut.setBackground(Color.WHITE);
        
        titre = new JLabel("Saisir la requête à executer :");
        panneauHaut.add(titre);
        
        texteRequete = new JTextField();
        panneauHaut.add(texteRequete);
        
        panneauFond.add(panneauHaut, BorderLayout.NORTH);
        
        add(panneauFond);
        pack();
        setVisible(true);
    }
    
    public JTextField getTextField(){
        return texteRequete;
    }
    
}

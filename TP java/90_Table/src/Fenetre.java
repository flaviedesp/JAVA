
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener
{   
    private JDesktopPane panneauFond;

    private JMenuBar barTable;
    private JMenu menuTables;
    private JMenuItem cont, vers, sect;
    
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteWindowClosing());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
        panneauFond = new JDesktopPane();
        panneauFond.setPreferredSize(new Dimension(800, 300));
        
        barTable = new JMenuBar();
        menuTables = new JMenu("Tables");
        cont = new JMenuItem("Contact");
        cont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.ALT_MASK));
        cont.addActionListener(this);
        vers = new JMenuItem("Versement");
        vers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.ALT_MASK));
        vers.addActionListener(this);
        sect = new JMenuItem("Secteur");
        sect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_MASK));
        sect.addActionListener(this);
        
        menuTables.add(cont);
        menuTables.add(vers);
        menuTables.add(sect);
        
        barTable.add(menuTables);
        setJMenuBar(barTable);
        
        
        add(panneauFond);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if (source == cont){
            Controleur.chercheContact(panneauFond);
        }
        
        if (source == vers){
            Controleur.chercheVersement(panneauFond);
        }
         if (source == sect){
            Controleur.info("secteurs");
            setLocationRelativeTo(panneauFond);
        }
    
        }   
        
// --------------------------------------------------------------------------
// Ecouteur de l'evenement fermeture de la fenetre
// --------------------------------------------------------------------------
    private class EcouteWindowClosing extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            Controleur.arreter();
        }
    }   
}

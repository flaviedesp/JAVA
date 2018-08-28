
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import utilitairesMG.divers.Colonne;
import utilitairesMG.graphique.table.ModeleColonneTable;


public class SousFenetre extends JInternalFrame implements InternalFrameListener, ActionListener
{

    private JTable table;
    private ModeleTableContact modeleTable;
    private ModeleColonneTable modeleColonne;
    
    
    private JMenuBar  barInterne;
    private JMenu  menuEdition;
    private JMenuItem  sup, rest;

    private JScrollPane defileur;
    
    public SousFenetre(String s,Vector<Contact> listeContacts,Vector<Colonne> listeColonnes, JDesktopPane p)
    {
        super(s,true,true,true,true);
        this.setPreferredSize(new Dimension(750, 200));
        addInternalFrameListener(this);
        
        barInterne = new JMenuBar();
        menuEdition = new JMenu("Edition");
        sup = new JMenuItem("Suppression de ligne");
        sup.addActionListener(this);
        rest = new JMenuItem("Restauration de ligne");
        rest.addActionListener(this);
        
        menuEdition.add(sup);
        menuEdition.add(rest);
        
        barInterne.add(menuEdition);
        setJMenuBar(barInterne);
        
   
// --------------------------------------------------------------------------
// Création de l'objet JTable :
// --------------------------------------------------------------------------
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

// --------------------------------------------------------------------------
// Recherche de la largeur en nombre de points de la lettre M de la police
// par defaut de la JTable.
// --------------------------------------------------------------------------
        Font fontParDefaut = table.getFont();
        int tailleM = table.getFontMetrics(fontParDefaut).stringWidth("M");

// --------------------------------------------------------------------------
// Creation des modeles de table et de colonne. 
// --------------------------------------------------------------------------
        modeleTable = new ModeleTableContact(listeContacts, listeColonnes);
        modeleColonne = new ModeleColonneTable(listeColonnes, tailleM);

// --------------------------------------------------------------------------
// Changement de l'editeur de la colonne 5 (CodeSecteur)
// --------------------------------------------------------------------------
        JComboBox combo = new JComboBox();
        combo.addItem(null);
        for (int i = 1; i <= 4; i++)
        {
            combo.addItem(i);
        }

        DefaultCellEditor editeur = new DefaultCellEditor(combo);
        editeur.setClickCountToStart(2);

        modeleColonne.setEditeurColonne(5, editeur);

// --------------------------------------------------------------------------
// Ajout des modeles a la JTable. 
// --------------------------------------------------------------------------
        table.setModel(modeleTable);
        table.setColumnModel(modeleColonne);
        defileur = new JScrollPane(table);
        defileur.getViewport().setBackground(new Color(220, 170, 255));
        
        add(defileur);          
        
        p.add(this);
        
        pack();
        setVisible(true);
        }

    
    @Override
    public void internalFrameOpened(InternalFrameEvent e)
    {
        
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e)
    {
        Controleur.arret(modeleTable.getListeContacts(),
                modeleTable.getListeContacts('M'),
                modeleTable.getListeContacts('I'));
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e)
    {
        
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e)
    {
       
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e)
    {
        
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e)
    {
        
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e)
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
            
                if (source == sup){
                int ligneSeletionnee[] = table.getSelectedRows();
                modeleTable.supprimer(ligneSeletionnee);
                table.revalidate();
                }else if(source == rest){
                    modeleTable.restaurer(); 
                    table.revalidate();
                }
    }
}
        

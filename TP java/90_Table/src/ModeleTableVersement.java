import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.table.*;

public class ModeleTableVersement extends ModeleTable
{

// -------------------------------------------------------------------------- 
// CONSTRUCTEUR
// -------------------------------------------------------------------------- 
// On transforme la liste d'objets 'Contact' en  lignes (Vector<Object>) pour
// alimenter le ModeleTable
// -------------------------------------------------------------------------- 
    public ModeleTableVersement(Vector<Versement> listeVersement,
                              Vector<Colonne> listeColonnes)
    {
        Vector<Vector<Object>> listeLignes = new Vector<Vector<Object>>();

        for (int i = 0; i < listeVersement.size(); i++)
        {
            Vector<Object> ligne = new Vector<Object>();
            Versement c = listeVersement.elementAt(i);

            ligne.addElement(c.getNumero());
            ligne.addElement(c.getNom());
            ligne.addElement(c.getAdresse());
            ligne.addElement(c.getCodePostal());
            ligne.addElement(c.getVille());
            ligne.addElement(c.getCodeSecteur());

            listeLignes.addElement(ligne);
        }

        setListeLignes(listeLignes);
        setListeColonnes(listeColonnes);
    }

// -------------------------------------------------------------------------- 
// Recuperation de la liste des contacts a partir de la liste des lignes du
// ModeleTable
// -------------------------------------------------------------------------- 
    public Vector<Versement> getListeVersement()
    {
        Vector<Versement> listeVersement = new Vector<Versement>();
        Vector<Vector<Object>> listeLignes = getListeLignes();

        for (int i = 0; i < listeLignes.size(); i++)
        {
            Vector<Object> ligne = listeLignes.elementAt(i);
            Versement c = new Versement();

            c.setNumero((Integer) ligne.elementAt(0));
            c.setNom((String) ligne.elementAt(1));
            c.setAdresse((String) ligne.elementAt(2));
            c.setCodePostal((String) ligne.elementAt(3));
            c.setVille((String) ligne.elementAt(4));
            c.setCodeSecteur((Integer) ligne.elementAt(5));

            listeVersement.addElement(c);
        }

        return listeVersement;
    }

// -------------------------------------------------------------------------- 
// Recuperation de la liste des contacts supprimes a partir de la liste des 
// lignes supprimees du ModeleTable
// -------------------------------------------------------------------------- 
    public Vector<Versement> getListeVersementSupprimes()
    {
        Vector<Versement> listeVersement = new Vector<Versement>();
        Vector<Vector<Object>> listeLignes = getListeLignesSupprimees();

        for (int i = 0; i < listeLignes.size(); i++)
        {
            Vector<Object> ligne = listeLignes.elementAt(i);
            Versement c = new Versement();

            c.setNumero((Integer) ligne.elementAt(0));
            c.setNom((String) ligne.elementAt(1));
            c.setAdresse((String) ligne.elementAt(2));
            c.setCodePostal((String) ligne.elementAt(3));
            c.setVille((String) ligne.elementAt(4));
            c.setCodeSecteur((Integer) ligne.elementAt(5));

            listeVersement.addElement(c);
        }

        return listeVersement;
    }

// -------------------------------------------------------------------------- 
// Recuperation de la liste des 'Contact' marques. 
// Le marqueur sert a reperer les contacts modifies ('M') ou inseres ('I').
// -------------------------------------------------------------------------- 
    public Vector<Versement> getListeVersement(Character marqueur)
    {
        Vector<Versement> listeVersement = new Vector<Versement>();
        Vector<Vector<Object>> listeLignes = getListeLignes();

        Vector<Character> marqueursLigne = getMarqueursLignes();

        for (int i = 0; i < listeLignes.size(); i++)
        {
            if (marqueursLigne.elementAt(i).compareTo(marqueur) == 0)
            {
                Vector<Object> ligne = listeLignes.elementAt(i);
                Versement c = new Versement();

                c.setNumero((Integer) ligne.elementAt(0));
                c.setNom((String) ligne.elementAt(1));
                c.setAdresse((String) ligne.elementAt(2));
                c.setCodePostal((String) ligne.elementAt(3));
                c.setVille((String) ligne.elementAt(4));
                c.setCodeSecteur((Integer) ligne.elementAt(5));

                listeVersement.addElement(c);
            }
        }

        return listeVersement;
    }

// -------------------------------------------------------------------------- 
// Rendre editables toutes les cellules 
// -------------------------------------------------------------------------- 
    public boolean isCellEditable(int lig, int col)
    {
         if (col == 0 && getValueAt(lig, 0) != null){
            return false;
        }else{
            return true;
        }   
        
    }

// -------------------------------------------------------------------------- 
// Creer une ligne de plus dans la JTable pour permettre les ajouts
// -------------------------------------------------------------------------- 
    public int getRowCount()
    {
        return super.getRowCount() + 1;
    }
}

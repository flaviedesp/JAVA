package daoServeurXML;

import java.util.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;
import utilitairesMG.divers.*;

public class EcouteurSaxXml extends DefaultHandler
{

    private boolean erreur;
    private String textErreur;

    private Vector<Colonne> colonnes = new Vector<Colonne>();
    private Colonne colonne;
    private Integer iCol;

    private Vector<Vector<Object>> lignes = new Vector<Vector<Object>>();
    private Vector<Object> ligne;
    private String texte;

    private String typElement;

    public void startElement(String nameSpaceURI,
                             String lname,
                             String qname,
                             Attributes attrs) throws SAXException
    {
        if (qname.compareTo("ERREUR") == 0)
        {
            erreur = true;
        }
        else if (qname.compareTo("RACINE") == 0)
        {
            erreur = false;
        }
        else if (qname.compareTo("COLONNE") == 0)
        {
            typElement = "COLONNE";
            colonne = new Colonne();
            iCol = 0;

        }
        else if (qname.compareTo("LIGNE") == 0)
        {
            typElement = "LIGNE";
            ligne = new Vector<Object>();
            iCol = 0;
        }
        else if (typElement.compareTo("LIGNE") == 0)
        {
            texte = null;
        }
    }

    public void endElement(String nameSpaceURI,
                           String lname,
                           String qname) throws SAXException
    {
        if (qname.compareTo("LIGNE") == 0)
        {
            lignes.addElement(ligne);
        }
        else if ((typElement.compareTo("LIGNE") == 0)
                && (qname.compareTo("RACINE") != 0))
        {
            Object object;
            String typeColonne = colonnes.elementAt(iCol).getType();
            try
            {
                if (texte != null)
                {
                    if ((typeColonne.compareTo("java.util.Date") == 0)
                            || (typeColonne.compareTo("java.sql.Date") == 0)
                            || (typeColonne.compareTo("java.sql.Time") == 0)
                            || (typeColonne.compareTo("java.sql.Timestamp")
                                                                        == 0))
                    {
                        object = CreationObjet.creeObjet(typeColonne, 
                                                            new Long(texte));
                    }
                    else
                    {
                        object = CreationObjet.creeObjet(typeColonne, texte);
                    }
                }
                else
                {
                    object = null;
                }                
            } catch (Exception e)
            {
                throw new SAXException(e.getMessage());
            }
            ligne.addElement(object);
            iCol++;
        }
    }

    public void characters(char[] ch, int start, int length)
    {
        texte = new String(ch, start, length);
        if (erreur == true)
        {
            textErreur = texte;
        }
        else if (typElement.compareTo("COLONNE") == 0)
        {
            switch (iCol)
            {
                case 0:
                    colonne.setNom(texte);
                    break;
                case 1:
                    colonne.setLongueur(new Integer(texte));
                    break;
                case 2:
                    colonne.setType(texte);
                    colonnes.addElement(colonne);
                    break;
            }
            iCol++;
        }
    }

    public boolean getErreur()
    {
        return erreur;
    }

    public String getTexteErreur()
    {
        return textErreur;
    }

    public Vector<Colonne> getColonnes()
    {
        return colonnes;
    }

    public Vector<Vector<Object>> getLignes()
    {
        return lignes;
    }
}

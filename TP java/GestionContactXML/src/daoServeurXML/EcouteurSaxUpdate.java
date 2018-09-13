package daoServeurXML;

import org.xml.sax.helpers.*;
import org.xml.sax.*;
import utilitairesMG.divers.*;
import java.util.*;
import metierMapping.*;

public class EcouteurSaxUpdate extends DefaultHandler
{

    private String textErreur;
    private Integer nombreLigne;

    private boolean erreur;

    public void startElement(String nameSpaceURI,
                             String lname,
                             String qname,
                             Attributes attrs) throws SAXException
    {
        if (qname.compareTo("ERREUR") == 0)
        {
            erreur = true;
        }
        if (qname.compareTo("MODIF") == 0)
        {
            erreur = false;
        }
    }

    public void characters(char[] ch, int start, int length)
    {
        String texte;

        texte = new String(ch, start, length);

        if (erreur == true)
        {
            textErreur = texte;
        }
        else
        {
            nombreLigne = new Integer(texte);
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

    public Integer getNombreLignes()
    {
        return nombreLigne;
    }
}

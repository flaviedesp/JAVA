
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import utilitairesMG.divers.*;

public class Versement implements Comparable <Versement>{
    
    private Integer numero;
    private Date date;
    private Double montant;
    private Integer numeroContact;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
    /* LES SETTERS */
    public void setNumero(Integer numero)
    {
        this.numero = numero;
    }
    public void setDate(Date date)
    {
        this.date = date;        
    }
    public void setMontant(Double montant)
    {
        this.montant = montant;
    }
    public void setNumeroContact(Integer numeroContact)
    {
        this.numeroContact = numeroContact;
    }
    
    /* LES GETTERS */
    
    public Integer getNumero()
    {
        return numero;
    }
    public Date getDate()
    {
        return date;
    }
    public Double getMontant()
    {
        return montant;
    }
    public Integer getNumerocontact()
    {
        return numeroContact;
    }
    
    /* COMPARAISON */
    public int compareTo(Versement versement)
    {
        return getDate().compareTo(versement.getDate());
    }
    
    /* AFFICHAGE */
    
    public String toString()
    {
        return numero + ";" + formatter.format(date) + ";" + montant + ";" + numeroContact;
    }
          

}

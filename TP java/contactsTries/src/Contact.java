
import java.io.*;
import java.util.*;

public class Contact implements Comparable<Contact> {

    private int numero;
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private int codeSecteur;
    private StringTokenizer token;

    public Contact(String ligne) {
        //System.out.println(getNumero() + ";" + getNom() + ";" + getAdresse() + ";" + getCodePostal() + ";" + getVille() + ";" + getCodeSecteur());
        token = new StringTokenizer(ligne, ";");
        this.numero = Integer.parseInt(token.nextToken());
        this.nom = token.nextToken();
        this.adresse = token.nextToken();
        this.codePostal = token.nextToken();
        this.ville = token.nextToken();
        this.codeSecteur = Integer.parseInt(token.nextToken());
    }

    public int compareTo(Contact contact) {
        if (this.numero < contact.numero) {
            return -1;
        } else if (this.numero > contact.numero) {
            return 1;
        } else {
            return 0;
        }
    }
    public String toString()
    {
        return this.numero +";" + this.nom +";" + this.adresse+";" + this.codePostal+";" + this.ville +";" + this.codeSecteur;
    }

}

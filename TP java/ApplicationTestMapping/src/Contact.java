/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.*;
import utilitairesMG.graphique.LF;
import utilitairesMG.jdbc.*;

/**
 *
 * @author afpa1797
 */
public class Contact {

    private int numero;
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private int codeSecteur;
    private Versement versement;
    private Secteur secteur;

    public Contact() {

    }
// --------------------------------------------------------------------------
// SETER
// --------------------------------------------------------------------------

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodeSecteur(int codeSecteur) {
        this.codeSecteur = codeSecteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    
    public void setVersement(Versement versement){
        this.versement = versement;
    }
// --------------------------------------------------------------------------
// GETERS
// --------------------------------------------------------------------------

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public Integer getCodeSecteur() {
        return codeSecteur;
    }
// --------------------------------------------------------------------------
// AFFICHAGE
// --------------------------------------------------------------------------

    public String toString() {
        String retour;
        retour = "Liste contact :\n";
        retour += "Numéro :         " + numero + "\n";
        retour += "Nom :            " + nom + "\n";
        retour += "Adresse :        " + adresse + "\n";
        retour += "Code Postal :    " + codePostal + "\n";
        retour += "Ville :          " + ville + "\n";
        retour += "Code Secteur :   " + codePostal + "\n";
        return retour;
    }

}

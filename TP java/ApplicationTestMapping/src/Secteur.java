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
public class Secteur {

    private int code;
    private String libelle;
    private Contact contact;

    public String getLibelle() throws SQLException {
        return libelle;
    }
    public int getCode(){
        return code;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public void setCode(int code){
        this.code= code;
    }
    
// --------------------------------------------------------------------------
// AFFICHAGE
// --------------------------------------------------------------------------
//    public String toString() {
//        String retour;
//        retour = "\n";
//        retour += "Secteur correspondant : \n";
//        retour += "Secteur : " + libelle + "\n";        
//        return retour;
//    }
}

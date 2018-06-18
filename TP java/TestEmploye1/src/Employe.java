/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afpa1797
 */
public class Employe {
 
    private int matricule;
    private String nom;

    public void setNom(String nom) 
    {
        this.nom = nom;
    }
    
    public void setMatricule(int matricule)
    {
        this.matricule = matricule;
    }

    public void afficheEmploye() {
        System.out.println("Nom         :" + nom);
        System.out.println("Matricule   :" + matricule);

    }
}

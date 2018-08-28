import java.awt.Color;
import java.awt.Rectangle;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afpa1797
 */
public class Carre extends Rectangle{
    private Color color;
    
    public Carre(int x, int y, int taille, Color color){
        super(x, y, taille, taille);
        this.color = color;       
    }
    
    public Color getColor(){
        return color;
    }        
}

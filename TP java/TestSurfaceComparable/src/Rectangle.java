
public class Rectangle extends Figure{
    
    int base;
    int hauteur;
    double surface;
    
    public double tabFigure(int base, int hauteur)
    {
        this.base =  base;
        this.hauteur = hauteur;
        surface = (base * hauteur);
        return surface;
    }

    @Override
    public double tabFigure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}

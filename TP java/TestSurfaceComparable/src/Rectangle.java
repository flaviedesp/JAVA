
public class Rectangle extends Figure{
    
    /* Propriete*/
    private int base;
    private  int hauteur;
    private float surface;
    
    /*Constructeur*/
    
    public Rectangle(int base, int hauteur)
    {
        this.base =  base;
        this.hauteur = hauteur;
        this.surface =(float) (base * hauteur);
    }
    
    /*Méthodes*/
    public float getSurface()
    {
        return surface;
    }
    public String toString()
    {
        return "\nRectangle de largeur " + base + ", de hauteur " + hauteur + ", Surface : " + getSurface();
    }

   
}

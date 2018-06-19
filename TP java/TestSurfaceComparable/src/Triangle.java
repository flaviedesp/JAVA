
public class Triangle extends Figure {
    
    /* Propriete*/

    private int base;
    private int hauteur;
    private float surface;
            
    /*Constructeur*/

    public Triangle(int base, int hauteur) {
        this.base = base;
        this.hauteur = hauteur;
        this.surface = (base * hauteur) / 2.f;
    }
    
    /*Méthodes*/
    public float getSurface()
    {
        return surface;
    }
    public String toString()
    {
        return "\nTriangle de base " + base + ", de hauteur " + hauteur + ", Surface : " + getSurface();
    }
     
}

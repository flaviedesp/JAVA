
public class Triangle extends Figure {
    
    /* Propriete*/

    int base;
    int hauteur;
    float surface;
    int compare;
    Triangle triangle1;
    Triangle triangle2;
    
    /*Constructeur*/

    public Triangle(int base, int hauteur) {
        this.base = base;
        this.hauteur = hauteur;
        this.surface = (base * hauteur) / 2;
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

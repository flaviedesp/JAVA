import static java.lang.Math.PI;
public class Cercle extends Figure {

    /* Propriete*/
    private int rayon;
    private float surface;
    
    /*Constructeur*/

    public Cercle(int rayon) {
        this.rayon =rayon;
        this.surface =(float) (PI * (rayon * rayon));
    }
    
    /*Méthodes*/
    public float getSurface()
    {
        return surface;
    }
    public String toString()
    {
        return "\nCercle de rayon " + rayon + ", Surface : " + getSurface();
    }
   
}

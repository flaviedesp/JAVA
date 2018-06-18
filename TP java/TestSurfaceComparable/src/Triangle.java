
public class Triangle extends Figure {

    int base;
    int hauteur;
    double surface;
    int compare;
    Triangle triangle1;
    Triangle triangle2;

    public double Triangle(int base, int hauteur) {
        this.base = base;
        this.hauteur = hauteur;
        surface = (base * hauteur) / 2;
        return surface;
    }

    public int compareTo(Triangle t) {
        triangle1 = (Triangle) t;        
        compare = triangle1.compareTo(triangle2);
        if(compare < 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
        
    }

}

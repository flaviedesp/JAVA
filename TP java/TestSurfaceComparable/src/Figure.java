
public abstract class Figure implements Comparable<Figure> {

    public int compareTo(Figure f) {
               
        if(f.getSurface() > this.getSurface())
        {
            return -1;
        }
        else if (f.getSurface() < this.getSurface())
        {
            return 1;
        }
        else{
            return 0;
        }
    }

    /*Méthodes*/
    public abstract float getSurface();

}

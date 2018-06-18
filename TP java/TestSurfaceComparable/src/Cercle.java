
public class Cercle extends Figure {

    int rayon;
    double surface;

    public double tabFigure(int rayon) {
        this.rayon =rayon;
        surface = (Math.PI * (rayon * rayon));
        return surface;
    }

    @Override
    public double tabFigure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

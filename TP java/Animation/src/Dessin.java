import animationMG.*;
import java.awt.geom.*;
import java.awt.*;
import java.util.*;

public class Dessin extends DessinAbstract implements Animable{

    private int rouge, vert, bleu;
    private int transparence;
    
    public Dessin()
    {
        Random r = new Random();
        rouge = r.nextInt(256);
        vert = r.nextInt(256);
        bleu = r.nextInt(256);
        transparence = r.nextInt(206) + 50;
    }
    
    public Shape getDessin()
    {
//        Arc2D camenbert;
//        camenbert = new Arc2D.Float(Arc2D.OPEN);
//        camenbert.setFrame(0, 0, 150, 100);
//        camenbert.setAngleStart(30);
//        camenbert.setAngleExtent(300);
//        return camenbert;
        
//        int tabX[]= {10, 180, 80, 20};
//        int tabY[]= {10, 50, 100, 70};
//        Polygon forme = new Polygon(tabX, tabY, 4);
        
//        Ellipse2D forme = new Ellipse2D.Float(50,50,100,50);
        
        QuadCurve2D forme = new QuadCurve2D.Float(150,50,50,150,100,150);
                        
        return forme;
    }
    
    public Color getCouleur()
    {
//        Color color = new Color(15, 157, 232);
        Color color = new Color(rouge, vert, bleu); /* couleur aleatoire*/
        return color;
    }
    public int getTransparence()
    {
        return transparence; /*transparence aléatoire*/
//        return 255;
    }
}


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afpa1797
 */
public class Panneau extends JPanel implements Runnable {
    
    private BufferedImage img;
    
    Panneau(String imageFond) {
        try {
            img =  ImageIO.read(new File(imageFond));    
        }
        catch(IOException e){
            
        }
        setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension taille = getSize();
        g.drawImage(img, 0, 0, taille.width,taille.height, null);
    }
    
     @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

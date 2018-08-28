
import javax.swing.SwingUtilities;


public class CONTROLE_1 {
    private static Fenetre fenetre;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        new Runnable() {
            
            public void run() {
                fenetre = new Fenetre("2 CASES A COCHER");
            }
        });
    }
    
}

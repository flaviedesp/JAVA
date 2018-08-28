
import javax.swing.SwingUtilities;

public class Souris {

    private static Fenetre fenetre;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                fenetre = new Fenetre("Déplacement vertical");
                
            }
        }
        );
    }
}

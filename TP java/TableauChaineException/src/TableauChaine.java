
import java.io.IOException;

public class TableauChaine {

    public static void main(String argv[]) {
        String tableau[];

        tableau = new String[3];
        tableau[0] = "Autruche";
        tableau[1] = "Bruant";
        tableau[2] = "Corbeau";
        System.out.println("Contenue de la Chaine : ");

        for (int i = 0; i <= 4; i++) {
            try {
                if (i == 4) {
                    throw new IOException();
                }
                System.out.println("tableau [" + i + "] = " + tableau[i]);
            } catch (ArrayIndexOutOfBoundsException ea) {
                System.out.println("Erreur vous ne pouvez pas dépasser la taille du tableau  = " + ea.getMessage());
            } catch (IOException e) {
                System.out.println("Erreur de IO");
            } finally {
                System.out.println("Test exception, i vaut : " + i);
            }
        }
    }
}


public class TableauChaine {

    public static void main(String argv[]) {
        String tableau[];

        tableau = new String[3];
        tableau[0] = "Autruche";
        tableau[1] = "Bruant";
        tableau[2] = "Corbeau";
        System.out.println("Contenue de la Chaine : ");

        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("tableau [" + i + "] = " + tableau[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur vous ne pouvez pas dépasser la taille du tableau  = " + e.getMessage());
        }

    }

}

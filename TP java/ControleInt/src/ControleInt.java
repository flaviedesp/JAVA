

public class ControleInt {

    private static int nbrSaisie;
    //private static boolean flag;

    public static int saisieInt(int min, int max) {
        boolean flag = false;
        do {
            try {
                System.out.println("Saisir un entier : ");
                nbrSaisie = ClavierInt.readInt(min, max);
                flag = true;
            } catch (BorneException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Nombre incorrect");
            }
        } while (!flag);
        return nbrSaisie;
    }
}

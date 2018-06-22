
public class BorneException extends Exception {

    public BorneException(int nbrSaisie, int min, int max) {
        super("Valeur " + nbrSaisie + " hors de [" + min + ", " + max + "]");
    }

}

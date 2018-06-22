
import java.io.*;

public class ClavierInt {

    private static BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
    private int min;
    private int max;

    public static int readInt(int min, int max) throws BorneException {

        int nbrSaisie;
        String ligne = "";

        try {
            ligne = clavier.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        nbrSaisie = Integer.parseInt(ligne);

        if (nbrSaisie < min || nbrSaisie > max) {
            throw new BorneException(nbrSaisie, min, max);
        }
        return nbrSaisie;

    }
}

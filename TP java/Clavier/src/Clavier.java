
import java.io.*;
import java.lang.*;

public class Clavier {

    /*Lecture clavier*/
    private static BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

    public static void setCodage(String codage) {
        InputStreamReader fluxCode;

        try {
            fluxCode = new InputStreamReader(System.in, codage);
            clavier = new BufferedReader(fluxCode);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int readInt() {
        int nbrSaisie;
        String compare = "";
        try {
            compare = clavier.readLine();
        } catch (IOException e) {
            System.out.println("Erreur Int " + e.getMessage());
        }
        nbrSaisie = Integer.parseInt(compare);

        return nbrSaisie;
    }

    public static double readDouble() {
        double nbrSaisie;
        String compare = "";
        try {
            compare = clavier.readLine();
        } catch (IOException e) {
            System.out.println("Erreur Double " + e.getMessage());
        }
        nbrSaisie = Double.parseDouble(compare);

        return nbrSaisie;
    }

    public static String readString() {
        String mot = "";

        try {
            mot = clavier.readLine();
        } catch (IOException e) {
            System.out.println("Erreur String " + e.getMessage());
        }

        return mot;
    }
}

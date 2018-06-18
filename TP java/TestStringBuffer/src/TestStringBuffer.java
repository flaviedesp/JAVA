
public class TestStringBuffer {

    public static void main(String argv[]) {
        String caract = "J'utilise JAVA avec brio !";
        StringBuffer caract2 = new StringBuffer("");

        /*Ex 1 Transformer les minusci=ules en majuscule et reciproquement*/
        System.out.println("\nTransformation des minuscules en majuscules et inversement : ");

        for (int i = 0; i < caract.length(); i++) {
            char ch = caract.charAt(i);

            if (Character.isLowerCase(ch)) {
                caract2.append(Character.toUpperCase(ch));
            } else {
                caract2.append(Character.toLowerCase(ch));
            }
        }
        System.out.println("J'utilise JAVA avec brio !");
        System.out.println(caract2);

        /*Ex 2 Remplacer les espaces par des _*/
        caract = "J'utilise JAVA avec brio !";

        caract = caract.replaceAll("\\s", "_");
        System.out.println("\nremplacement des espaces par _ :");
        System.out.println(caract);

        /*Ex 3 Remplacer JAVA par C++*/
        caract = "J'utilise JAVA avec brio !";

        caract = caract.replaceAll("JAVA", "C++");
        System.out.println("\nremplacement de JAVA par C++ :");
        System.out.println(caract);

        /*Ex 4 Ecrire la chaine inversé*/
        caract = "J'utilise JAVA avec brio !";

        StringBuffer caract3 = (new StringBuffer(caract)).reverse();
        System.out.println("\nInversement de la chaine :");
        System.out.println(caract3);

        /*Ex 5 Comptez combien de fois chaque lettre est utilisée*/
        caract = "J'utilise JAVA avec brio !";

        int i, nombre;
        char lettre;

        System.out.println("\nNombre de lettre utilisée :");

        for (lettre = (char) 'A'; lettre <= 'Z'; lettre++) {
            nombre = 0;

            for (i = 0; i < caract.length(); i++) {
                if (lettre == Character.toUpperCase(caract.charAt(i))) {
                    nombre++;
                }
            }
            if (nombre > 0) {
                System.out.println(lettre + " = " + nombre);
            }
        }
    }

}

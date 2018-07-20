
public class TestClavier {
    public static void main(String argv[]) throws Exception
    {
        Clavier.setCodage("Cp1252");
        
        int verifEntier;
                
        System.out.println("ecrire un entier : ");
        verifEntier = Clavier.readInt();
        System.out.println("l'entier est : " + verifEntier);
        
        double verifDouble;
        
        System.out.println("ecrire un double : ");
        verifDouble = Clavier.readDouble();
        System.out.println("le double est : " + verifDouble);
        
        String verifString;
        
        System.out.println("ecrire une chaine : ");
        verifString = Clavier.readString();
        System.out.println("la chaine est : " + verifString);
        
    }
    
    
}

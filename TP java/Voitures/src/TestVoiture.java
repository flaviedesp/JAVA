
public class TestVoiture
{
   public static void main(String agrv[])
   {
       Garage g1, g2;
       Vendeur vendeur1, vendeur2, vendeur3;
       Voiture v1, v2, v3, v4;
       
       System.out.println("LISTE DES GARAGES DE LA MARQUE " + Garage.getNomMarque() + "\n");
       
       g1 = new Garage("Avenue des Champs Elysées 75008 PARIS");
       g2 = new Garage();
       
       System.out.println(g1);
       System.out.println(g2);
       
       vendeur1 = new Vendeur("Oie", "BERNACHE", g1);
       vendeur2 = new Vendeur("Aigle", "ROYAL", g2);
       vendeur3 = new Vendeur("Balbuzard", "PECHEUR", g1);
       
       System.out.println("\n\nLISTE DES VENDEURS");
       System.out.println(vendeur1);
       System.out.println(vendeur2);
       System.out.println(vendeur3);
       
       v1 = new Voiture();
       v2 = new Voiture(2004);
       v3 = new Voiture(vendeur1);
       v4 = new Voiture(3010, vendeur2);
       
       System.out.println("\n\nLISTE DES VOITURES :");
       System.out.println(v1);
       System.out.println(v2);
       System.out.println(v3);
       System.out.println(v4);
   }
}


import utilitairesMG.divers.*;

public class TestVoiture {

    public static void main(String agrv[]) {
        Garage g1, g2;
        Vendeur tableauVendeur[];
        Voiture tableauVoiture[];
        int nbrVoiture;
        int numMoteur;
        String nomVendeur;
        String compNomVendeur;

        System.out.println("LISTE DES GARAGES DE LA MARQUE " + Garage.getNomMarque() + "\n");

        g1 = new Garage("Avenue des Champs Elysées 75008 PARIS");
        g2 = new Garage();

        System.out.println(g1);
        System.out.println(g2);

        tableauVendeur = new Vendeur[3];

        tableauVendeur[0] = new Vendeur("Oie", "BERNACHE", g1);
        tableauVendeur[1] = new Vendeur("Aigle", "ROYAL", g2);
        tableauVendeur[2] = new Vendeur("Balbuzard", "PECHEUR", g1);

        System.out.print("\nEntrer le nombre de voiture a creer : ");
        nbrVoiture = Clavier.readInt();

        tableauVoiture = new Voiture[nbrVoiture];

        for (int i = 0; i < nbrVoiture; i++) {
            System.out.println("\nVoiture numero " + (i + 1) + " : ");
            System.out.print("Numero de moteur (ou 0) : ");
            numMoteur = Clavier.readInt();

            System.out.print("Nom du vendeur : ");
            nomVendeur = Clavier.readString();
            int j = 0;

            while (tableauVendeur.length > j && !nomVendeur.equalsIgnoreCase(tableauVendeur[j].getNom())) {
                j++;
            }

            if (numMoteur != 0) {
                if (j < tableauVendeur.length) {
                    tableauVoiture[i] = new Voiture(numMoteur, tableauVendeur[j]);
                } else {
                    tableauVoiture[i] = new Voiture(numMoteur);
                }
            } else if (j < tableauVendeur.length) {
                tableauVoiture[i] = new Voiture(tableauVendeur[j]);
            } else {
                tableauVoiture[i] = new Voiture();
            }
        }
        for (nbrVoiture = 0; nbrVoiture < tableauVoiture.length; nbrVoiture++) {
            System.out.println("\n" + tableauVoiture[nbrVoiture]);
        }
    }
}

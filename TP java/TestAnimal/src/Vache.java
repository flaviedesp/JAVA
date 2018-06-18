
public class Vache extends Animal {

    private static int ageMaximalVache = 5;
    private int ageV;

    public Vache(int ageV) {
        super(ageV);
    }

    public void crier() {
        System.out.println("MEUH !");
    }

    public void afficheMeur() {
        System.out.println("Une vache vient de mourrir !");
    }

    public int getAgeMaximum() {
        return ageMaximalVache;
    }

    public void afficheAge() {
        System.out.println("Cette vache a maintenant " + getAge() + " ans");
    }
}

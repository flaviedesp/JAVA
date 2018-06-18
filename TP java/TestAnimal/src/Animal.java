
public class Animal {

    private boolean vivant;
    private int age;
    private static int nombreAnimauxVivants;
    private static int ageMaximal = 3;

    public Animal(int age) {
        this.age = age;
        vivant = true;
        nombreAnimauxVivants++;
    }

    public void vieillir() {
        if (vivant) {
            age++;
            if (age > getAgeMaximum()) {
                mourrir();
            } else {
                afficheAge();
            }
        }
    }

    public int getAgeMaximum() {
        return ageMaximal;
    }

    public void afficheAge() {
        System.out.println("Cet animal a maintenant " + getAge() + " ans");
    }

    public void mourrir() {
        if (vivant) {
            vivant = false;
            nombreAnimauxVivants--;
            afficheMeur();
        }
    }

    public void afficheMeur() {
        System.out.println("Un animal vient de mourrir !");
    }

    public void crier() {
        System.out.println("Je suis un animal !");
    }

    public boolean getVivant() {
        return vivant;
    }

    public static int getNombreAnimauxVivants() {
        return nombreAnimauxVivants;
    }

    public int getAge() {
        return age;
    }
}

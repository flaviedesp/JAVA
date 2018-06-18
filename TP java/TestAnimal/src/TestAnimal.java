
public class TestAnimal {

    public static void main(String argv[]) {
        Animal tableAnimal[] = new Animal[2];
        int iAnimal;

        tableAnimal[0] = new Vache(1);
        tableAnimal[1] = new Animal(2);

        while (Animal.getNombreAnimauxVivants() > 0) {
            
            for  (iAnimal = 0; iAnimal < 2; iAnimal++) {
                
                if (tableAnimal[iAnimal].getVivant()) {                    
                    tableAnimal[iAnimal].crier();
                    tableAnimal[iAnimal].vieillir();
                }
            }
        }
    }
}

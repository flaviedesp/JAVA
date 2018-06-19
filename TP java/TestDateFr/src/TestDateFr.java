import java.util.*;
import java.text.*;
import utilitairesMG.divers.Clavier;
//import utilitairesMG.divers.DateFr;


public class TestDateFr {
    public static void main(String argv[]) throws ParseException
    {
        DateFr date1, date2;
        String saisieDate;
        
        date1 = new DateFr();
        date2 = new DateFr("03/09/2017");
        System.out.println("date 1 : " + date1 + " date 2 : " + date2);
        
        date1.set("31/01/2017");
        System.out.println("\nDate 1 apres set : " + date1);
        
        date1.add(Calendar.MONTH, 3);
        System.out.println("\nDate 1 apres add : " + date1);
        
        date1.setFormat("EEEE dd MMMM yyyy");
        System.out.println("\nDate 1 apres setFormat : " + date1);
        
        date1.setFormat("dd MMMM yyyy");
        System.out.print("\nSaisir une date (" + date1.toFormat() + " ): ");
        saisieDate = Clavier.readString();
        date1.set(saisieDate);
        System.out.println("date 1 apres set : " + date1);
        
        System.out.println("\nDate 1 : " + date1 + " date 2 : " + date2);
        System.out.println("Difference : " + DateFr.difDates(date1, date2) + " jour(s)");
    }

       
}

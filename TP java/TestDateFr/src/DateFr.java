
import java.text.*;
import java.util.*;

public class DateFr extends GregorianCalendar {
    
    /* propriete*/

    private SimpleDateFormat formatDate;
    
    /* constructeur*/
 
    public DateFr() {
        super();
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
    }

    public DateFr(String dateS) {
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = formatDate.parse(dateS);
            setTime(date);
        } catch (ParseException e) {
            System.out.println("Erreur de creation de la date");
        }
    }
    
    /* Methodes*/

    public void set(String dateS) {
        formatDate = new SimpleDateFormat("dd MMMM yyyy");
        try { 
            Date date = formatDate.parse(dateS);
            setTime(date);
        } catch (ParseException e) {
            System.out.println("Erreur de creation de la date");
        }
    }

    public void setFormat(String format) {
        
        formatDate.applyPattern(format);
    }

    public String toFormat() {
        return formatDate.toPattern();
    }

    public static long difDates(DateFr date1, DateFr date2) {
        long difference = (date2.getTime()).getTime() - (date1.getTime()).getTime();
        difference = (difference) / (1000 * 3600 * 24);
        return difference;
    }
    
    public String toString()
    {
        return formatDate.format(getTime());
    }
}

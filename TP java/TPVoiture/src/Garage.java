
public class Garage
{
    private static String nom = "VOLIERE SA";
    private String adresse;
           
    public static String getNomMarque()
    {
        return nom ;
    }
    
    public Garage(String adresse)
    {
        this.adresse = adresse;
    }
   
    public Garage()
    {
        this.adresse = "Rue Paradis 13001 MARSEILLE";
    }
    
    public String toString()
    {
        return nom +" - " + adresse;
    }
        
            }

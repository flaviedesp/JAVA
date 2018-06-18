
public class Voiture
{
    private static int numAutomatique = 0;
    private static int numMoteurAutomatique = 1000;
    private int numero;
    private int moteur;
    private Vendeur vendeur;
    private Garage garage;
    
    public Voiture()
    {   
        numAutomatique++;
        numMoteurAutomatique++;
        this.numero = numAutomatique;
        this.moteur = numMoteurAutomatique;
        //this.vendeur = vendeur;        
    }
    
    public Voiture(int moteur)
    {       
        numAutomatique++;
        this.numero = numAutomatique;
        this.moteur = moteur;
        //this.vendeur = vendeur;        
    }
    
    public Voiture(Vendeur vendeur)
    {
        numAutomatique++;
        numMoteurAutomatique++;
        this.numero = numAutomatique;
        this.moteur = numMoteurAutomatique;
        this.vendeur = vendeur;          
    }
    
    public Voiture(int moteur, Vendeur vendeur)
    {  
        numAutomatique++;
        this.numero = numAutomatique;
        this.moteur = moteur;
        this.vendeur = vendeur;         
    }
    public String toString()
    {
        if (vendeur != null)
        {            
            return "\n" + "VOITURE     : " + numero + "\n" + 
               "MOTEUR      : NMOT" + moteur + "\n" + 
               "VENDEUR     :" + "\n" +
                vendeur;           
        }
        else
        {
          return "VOITURE     : " + numero + "\n" + 
               "MOTEUR      : NMOT" + moteur + "\n" + 
               "VENDEUR : INCONNU\n"; 
        }
        
    }
       
}

import java.util.*;
import java.io.IOException;

public class ExceptionTableauString {
    public static void main(String[] args) 
    {
       String tableau[]={"autruche","bruant","corbeau"};
       int i;     
      try
      {
        for (i=0;i<=5;i++)
            {
                 System.out.println(tableau[i]);
            }       
            try 
            {
                if(i==4)
                {
                    throw new IOException("NO NO NO");
                }
                
                System.out.println(tableau[i]);
            }           
            catch (IOException IO)
            {
                System.out.println(IO.getMessage());
            }
      }
      catch (ArrayIndexOutOfBoundsException AIOoB)
              {
                 System.out.println("T'as dépassé les bornes mec!");
              }
    }
}
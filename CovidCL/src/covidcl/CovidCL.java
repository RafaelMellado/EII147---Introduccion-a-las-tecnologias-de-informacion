package covidcl;
import java.io.*;

/**
 *
 * @author rafaelmellado
 */
public class CovidCL 
{
    
    public static void main(String[] args) throws IOException
    {
        int cadenaADN=0, opción;
        double factorComparación=0;
        
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        
        do
        {
            System.out.println("Menú de usuario: ");
            System.out.println("1. Ingresar cadena de ADN");
            System.out.println("2. Ingresar factor de comparación");
            System.out.println("3. Verificar mutación");
            System.out.println("4: Salir");
            System.out.println("\n Ingrese opción: ");
            opción=Integer.parseInt(lector.readLine());
            
            
            switch (opción)
            {
                case 1:
                    do
                    {
                        System.out.println("Ingrese valor de cadena de ADN, recuerde que debe ser positivo: ");
                        cadenaADN=Integer.parseInt(lector.readLine());
                    }while(cadenaADN<=0);
                    break;
                case 2:
                    System.out.println("Ingrese valor de factor de comparación: ");
                    factorComparación=Double.parseDouble(lector.readLine());
                    break;
                case 3:
                    /*Primero se invierte cadena ADN*/
                    int ADNInvertido=0;
           
                    while(cadenaADN>0)
                    {
                        int digito=cadenaADN%10;
                        cadenaADN=cadenaADN/10;
                        ADNInvertido=(ADNInvertido*10)+digito;
                    }
                    
                    /*Se calcula raiz*/
                    boolean calculado=false;
                    for(double raiz=0.1; ADNInvertido>=raiz*raiz && calculado==false; raiz=raiz+0.1)
                    {
                        if(raiz*raiz>=ADNInvertido)
                        {
                            if(Math.abs(raiz-factorComparación)<0.0000001)
                            {
                                System.out.println("El virus mutó a buena persona");
                            }
                            else
                            {
                                System.out.println("Fracaso en la operación");
                            }
                            calculado=true;
                        }
                    }
                    break;
                default:
                    System.out.println("¡Hasta pronto!");
            } 
        }while(opción!=4);
    }
}

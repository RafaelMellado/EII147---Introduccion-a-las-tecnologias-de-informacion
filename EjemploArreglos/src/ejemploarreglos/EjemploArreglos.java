package ejemploarreglos;
import java.io.*;

public class EjemploArreglos 
{

    public static void main(String[] args) throws IOException {

        int valores[], tamaño;
        
        BufferedReader lector = new  BufferedReader( new InputStreamReader( System.in ) );
        
        do
        {
            System.out.println("Ingrese el tamaño de la coleccion:");
            tamaño=Integer.parseInt(lector.readLine());
        }while(tamaño<=0);
        
        valores= new int[tamaño];
        boolean finaliza=false;
        
        for(int i=0; i<valores.length && finaliza==false; i++)
        {
            System.out.println("Ingrese un valor para llenar el arreglo (0: Finaliza llenado):");
            valores[i]=Integer.parseInt(lector.readLine());
            
            if(valores[i]==0)
            {
                finaliza=true;
            }
        }
        
        System.out.println("Valores almacenados:");
        finaliza=false;
        for(int i=0; i<valores.length && finaliza==false; i++)
        {
            if(valores[i]!=0)
            {
                System.out.println(valores[i]);
            }
            else
            {
                finaliza=true;
            }
        }
        
        Double prom=0.0;
        int contador=0;
        finaliza=false;
        for(int i=0; i<valores.length && finaliza==false; i++)
        {
            if(valores[i]!=0)
            {
                prom=prom+valores[i];
                contador++;
            }
            else
            {
                finaliza=true;
            }
        }
        
        if(contador>0)
        {
            prom=prom/contador;
            System.out.println("El promedio es: "+prom);
        }
        else
        {
            System.out.println("No hay datos para calcular promedio");
        }
        
    }
    
}

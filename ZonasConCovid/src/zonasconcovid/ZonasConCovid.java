package zonasconcovid;
import java.io.*;

/**
 *
 * @author rafaelmellado
 */
public class ZonasConCovid 
{    
    public static void main(String[] args) throws IOException
    {
        String localidades[];
        int muestras[][]; 
        int cantidadLocalidades=0, opción;
        double promedioContagio=0;
        
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
        
        do
        {
            System.out.println("Menú de usuario: ");
            System.out.println("1. Ingresar cantidad de localidades");
            System.out.println("2. Agregar muestra a localidad");
            System.out.println("3. Borrar localidades “buena persona”");
            System.out.println("4. Localidades con pandemia");
            System.out.println("5. Salir");

            System.out.println("\n Ingrese opción: ");
            opción=Integer.parseInt(lector.readLine());
            
            
            switch (opción)
            {
                case 1:
                    do
                    {
                        System.out.println("Ingrese cantidad de localidades, recuerde que debe ser positivo: ");
                        cantidadLocalidades=Integer.parseInt(lector.readLine());
                    }while(cantidadLocalidades<=0);
                    
                    /*Instancia de colecciones */
                    localidades=new String[cantidadLocalidades];
                    muestras=new int[100][cantidadLocalidades];
                    break;
                case 2:
                    String nombreLocalidad;
                    int díaRegistro, cantidadCasos;
                    
                    System.out.println("Ingrese nombre de localidad: ");
                    nombreLocalidad=lector.readLine();
                    
                    do
                    {
                        System.out.println("Ingrese día en el cual desea registrar: ");
                        díaRegistro=Integer.parseInt(lector.readLine());
                    }while(díaRegistro<=0 && díaRegistro>100);
                    
                    do
                    {
                        System.out.println("Ingrese la cantidad de casos a registrar: ");
                        cantidadCasos=Integer.parseInt(lector.readLine());
                    }while(cantidadCasos<=0);
                    
                    boolean agregado=false;
                    for(int i=0; i<localidades.length && agregado==false; i++)
                    {
                        if(localidades[i]!=null && localidades[i].equals(nombreLocalidad))
                        {
                            if(muestras[díaRegistro-1][i]==0)
                            {
                                muestras[díaRegistro-1][i]=cantidadCasos;
                            }
                            else
                            {
                                muestras[díaRegistro-1][i]=muestras[díaRegistro-1][i]+cantidadCasos+1;
                            }
                            agregado=true;
                        }
                    }
                    break;
                case 3:
                    double indicadorMundialContagio;
                    
                    System.out.println("Ingrese el indicador mundial de contagio: ");
                    indicadorMundialContagio=Double.parseDouble(lector.readLine());
                    
                    for(int i=0; i<localidades.length; i++)
                    {
                        if(localidades[i]!=null)
                        {
                            int suma=0, contador=0;
                            for(int j=0; j<muestras.length; j++)
                            {
                                if(muestras[j][i]>0)
                                {
                                    suma=suma+muestras[j][i];
                                    contador++;
                                }
                            }
                            if(contador>0)
                            {
                                promedioContagio=(double)suma/contador;

                                if(promedioContagio<indicadorMundialContagio)
                                {
                                    localidades[i]=null;
                                    for(int j=0; j<muestras.length; j++)
                                    {
                                        muestras[j][i]=0;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    double mayorPromedio;
                    boolean mayor=false;
                    
                    /*Calcula promedio y búsqueda del mayor*/
                    for(int i=0; i<localidades.length; i++)
                    {
                        if(localidades[i]!=null)
                        {
                            int suma=0, contador=0;
                            for(int j=0; j<muestras.length; j++)
                            {
                                if(muestras[j][i]>0)
                                {
                                    suma=suma+muestras[j][i];
                                    contador++;
                                }
                            }
                            if(contador>0)
                            {
                                promedioContagio=(double)suma/contador;

                                /*Determina del mayor*/
                                if(mayor==false || promedioContagio>mayorPromedio)
                                {
                                    mayor=true;
                                    mayorPromedio=promedioContagio;
                                }
                            }
                        }
                    }
                    
                    /*Mostrar mayores*/
                    if(mayor==true)
                    {
                        for(int i=0; i<localidades.length; i++)
                        {
                            if(localidades[i]!=null)
                            {
                                int suma=0, contador=0;
                                for(int j=0; j<muestras.length; j++)
                                {
                                    if(muestras[j][i]>0)
                                    {
                                        suma=suma+muestras[j][i];
                                        contador++;
                                    }
                                }
                                if(contador>0)
                                {
                                    promedioContagio=(double)suma/contador;
                                    
                                    if(Math.abs(promedioContagio-mayorPromedio)>0.0000001)
                                    {
                                        System.out.println(localidades[i]);
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Chile abre los malls");
                    }
                    break;
                default:
                    System.out.println("¡Hasta pronto!");
            } 
        }while(opción!=5);
    }
    
}

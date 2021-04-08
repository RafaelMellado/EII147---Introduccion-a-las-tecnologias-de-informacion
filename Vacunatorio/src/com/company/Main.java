package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	/*Llenado ya existe*/


        /* 1. declarar dos arreglos sincrónicos con pLibre
        2. mostrar elementos por pantalla
        3. determinar el mayor
        4. crear un nuevo arreglo de tamaño exacto con aquellas regiones que tienen una cantidad de vacunacion sobre el promedio

         */

        String regiones[];
        int vacunasSuministradas[], cantidadRegiones, pLibre;
        BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("Ingrese la cantidad de regiones que manejará");
            cantidadRegiones=Integer.parseInt(lector.readLine());
        }while(cantidadRegiones<=0);

        regiones=new String[cantidadRegiones];
        vacunasSuministradas=new int[cantidadRegiones];

        /*llenado*/
        pLibre=0;



        /*2. Mostrar elementos por pantalla compacto con pLibre*/
        System.out.println("Mostramos regiones");
        for(int i=0; i<pLibre; i++)
            System.out.println("-Region: "+regiones[i]+" tiene "+vacunasSuministradas[i]+ "vacunas suministradas.");

        /*2. Mostrar elementos por pantalla compacto sin pLibre*/
        System.out.println("Mostramos regiones");
        for(int i=0; i<regiones.length && regiones[i]!=null ; i++)
            System.out.println("-Region: "+regiones[i]+" tiene "+vacunasSuministradas[i]+ "vacunas suministradas.");

        /*2. Mostrar elementos por pantalla no compacto*/
        System.out.println("Mostramos regiones");
        for(int i=0; i<regiones.length; i++)
        {
            if(regiones[i]!=null)
                System.out.println("-Region: "+regiones[i]+" tiene "+vacunasSuministradas[i]+ "vacunas suministradas.");
        }

        /*3. Determinar el mayor*/
        int posicionMayor=-1;
        for(int i=0; i<pLibre; i++)
        {
            if(posicionMayor==-1 || vacunasSuministradas[i]>vacunasSuministradas[posicionMayor])
                posicionMayor=i;
        }
        if(posicionMayor!=-1)
            System.out.println("La región con mayor cantidad de vacunas es: "+regiones[posicionMayor]);


        /*4. regiones sobre promedio*/
        double promedio=0;
        for(int i=0; i<pLibre; i++)
            promedio+=vacunasSuministradas[i];

        if(pLibre>0) {
            promedio = promedio / pLibre;

            int contador = 0;
            for (int i = 0; i < pLibre; i++) {
                if (vacunasSuministradas[i] > promedio)
                    contador++;

                if (contador > 0) {
                    String regionesTop[] = new String[contador];
                    int indiceRegionesTop = 0;

                    for (int k = 0; k < pLibre; k++) {
                        if (vacunasSuministradas[k] > promedio) {
                            regionesTop[indiceRegionesTop] = regiones[k];
                            indiceRegionesTop++;
                        }
                    }


                    for(int j=0; j<regionesTop.length; j++)
                    {
                        System.out.println(regionesTop[j]);
                    }
                }
            }
        }

        /*TAREA:
        *
        * Rutear el código desarrollado en la opción 4 (promedio) y encontrar cual es el error lógico que se da en la solución desarrollada.
        *
        * */








        /*4.
        * a. calcular promedio
        * b. contar cuantos estan sobre ese promedio
        * c. si cantidad contada >0
        *   i. crear el arreglo
        *   ii. llenar el arreglo copiando las regiones
        *   iii. mostrar arreglo*/





        /*3. Determinar el mayor*/







    }
}

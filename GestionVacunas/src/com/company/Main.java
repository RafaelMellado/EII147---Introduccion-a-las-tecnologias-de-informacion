package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        int cantidadVacunatorios, limiteVacunados;
        BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));

        do{
            System.out.println("Indique cantidad de vacunatorios");
            cantidadVacunatorios=Integer.parseInt(lector.readLine());
        }while(cantidadVacunatorios<=0);

        do{
            System.out.println("Ingrese la cantidad limite de vacunados de los vacunatorios: ");
            limiteVacunados=Integer.parseInt(lector.readLine());
        }while(limiteVacunados<=0);

        String vacunatorios[]=new String[cantidadVacunatorios];
        int pLibre=0;

        String vacunados[][]=new String[limiteVacunados][cantidadVacunatorios];

        System.out.println("Bienvenidos, seleccione una opción");
        System.out.println("1. Agregar vacunado");

        int opcion=Integer.parseInt(lector.readLine());

        switch(opcion)
        {
            case 0:
                if(pLibre<vacunatorios.length)
                {
                    System.out.println("Ingrese nombre de nuevo vacunatorio");
                    String nombreVacunatorio=lector.readLine();

                    boolean repetido=false;
                    for(int i=0; i<pLibre && repetido==false; i++)
                    {
                        if(vacunatorios[i].equals(nombreVacunatorio))
                            repetido=true;
                    }

                    if(repetido==false)
                    {
                        vacunatorios[pLibre]=nombreVacunatorio;
                        pLibre++;
                        System.out.println("Vacunatorio agregado!");
                    }
                    else
                        System.out.println("Vacunatorio repetido");
                }
                else
                    System.out.println("No hay más espacios para vacunatorios!");
                break;

            case 1:
                System.out.println("Indique el identificador del vacunatorio:");
                String vacunatorio=lector.readLine();

                System.out.println("Indique el rut a vacunar:");
                String rut=lector.readLine();

                int cantidadDosis=0;
                boolean agregado=false;

                for(int i=0; i<pLibre; i++)
                {
                    for(int j=0; j<vacunados.length; j++)
                    {
                        if(vacunados[j][i]!=null && vacunados[j][i].equals(rut))
                            cantidadDosis++;
                    }
                }

                if(cantidadDosis<2)
                {
                    for(int i=0; i<pLibre; i++)
                    {
                        if(vacunatorios[i].equals(vacunatorio))
                        {
                            for(int j=0; j<vacunados.length; j++)
                            {
                                if(vacunados[j][i]==null)
                                {
                                    vacunados[j][i]=rut;
                                    agregado=true;
                                }
                            }
                        }
                    }
                }

                if(agregado==true)
                    System.out.println("Vacuna agregada!");
                else
                    System.out.println("Ya tienes todas las dosis o no existe el vacunatorio");
                break;

            case 2:
                int cantMayor=-1;
                for(int i=0; i<pLibre; i++)
                {
                    int contadorVacunados=0;
                    for(int j=0; j<vacunados.length; j++)
                    {
                        if(vacunados[j][i]!=null)
                            contadorVacunados++;
                    }

                    if(cantMayor==-1 || contadorVacunados>cantMayor)
                        cantMayor=contadorVacunados;
                }

                System.out.println("Vacunatorios con más vacunas:");
                for(int i=0; i<pLibre; i++)
                {
                    int contadorVacunados=0;
                    for(int j=0; j<vacunados.length; j++)
                    {
                        if(vacunados[j][i]!=null)
                            contadorVacunados++;
                    }

                    if(contadorVacunados==cantMayor)
                        System.out.println(vacunatorios[i]);
                }
                break;

            case 3:
                System.out.println("Ingrese vacunatorio de origen");
                String vacunatorioOrigen =lector.readLine();

                System.out.println("Ingrese rut del paciente");
                String rutPaciente =lector.readLine();

                System.out.println("Ingrese vacunatorio de destino");
                String vacunatorioDestino =lector.readLine();

                boolean trasladado=false;
                for(int i=0; i<pLibre && trasladado==false; i++)
                {
                    if(vacunatorios[i].equals(vacunatorioOrigen))
                    {
                        for(int j=0; j<vacunados.length && trasladado==false; j++)
                        {
                            if(vacunados[j][i]!=null && vacunados[j][i].equals(rutPaciente))
                            {
                                for(int k=0; k<pLibre && trasladado==false; k++)
                                {
                                    if(vacunatorios[k].equals(vacunatorioDestino))
                                    {
                                        for(int e=0; e<vacunados.length && trasladado==false; e++)
                                        {
                                            if(vacunados[e][k]==null)
                                            {
                                                vacunados[e][k]=rutPaciente;
                                                vacunados[j][i]=null;
                                                trasladado=true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(trasladado==true)
                    System.out.println("Paciente trasladado correctamente!");
                else
                    System.out.println("No se pudo trasladar el paciente");
                break;

            case 4:

        }




    }
}

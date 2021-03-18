package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int opcion, montoAcumulado=0, cantidadVentas=0;;


        do{

            System.out.println("Bienvenido a almacen DON GENARO, seleccione su opción");
            System.out.println("1: Realizar venta");
            System.out.println("2: Ver ventas acumuladas");
            System.out.println("3: Ver el IVA que se debe pagar");
            System.out.println("4: Salir");
            System.out.print("Digite su opcion: ");
            opcion=Integer.parseInt(reader.readLine());

            switch (opcion)
            {
                case 1:
                    int montoProducto=0, montoVenta=0, montoPaga=0, medioPago=0, montoCobrar=0;
                    do {

                        do {
                            System.out.print("Ingrese el monto del producto: $");
                            montoProducto=Integer.parseInt(reader.readLine());
                        }while(montoProducto<0);

                        montoVenta=montoVenta+montoProducto;

                    }while(montoProducto!=0);

                    int iva=(int)(montoVenta*0.19);
                    montoCobrar=montoVenta+iva;

                    System.out.println("El monto a pagar es: "+(montoVenta+iva));
                    System.out.print("Ingrese modo de pago (1: Efectivo, 2: Tarjeta): ");
                    medioPago=Integer.parseInt(reader.readLine());

                    if(medioPago==2)
                    {
                        montoVenta+=montoVenta*0.04;
                        montoCobrar=montoVenta+iva;
                        System.out.println("El monto a pagar es: "+montoCobrar);
                        System.out.println("Venta procesada!");
                    }
                    else
                    {
                        do{
                            System.out.println("El monto a pagar es: "+montoCobrar);
                            System.out.print("Ingrese monto con el que paga: $");
                            montoPaga=Integer.parseInt(reader.readLine());
                        }while(montoPaga<montoCobrar);

                        System.out.println("Venta procesada!");
                        System.out.println("Su vuelto es: $"+(montoPaga-montoCobrar));
                    }

                    montoAcumulado+=montoVenta;
                    cantidadVentas++;
                    break;
                case 2:
                    System.out.println("El total de ventas acumuladas suma $"+montoAcumulado);
                    System.out.println("Se han realizado "+cantidadVentas+" cantidad de ventas");
                    break;
                case 3:
                    System.out.println("El IVA a pagar acumulado es: $"+((int)(montoAcumulado*0.19)));
                    break;
                case 4:
                    System.out.println("Adios, eres el mejor!");
                    break;
                default:
                    System.out.println("La opción seleccionada no existe.");
                    break;
            }


        }while(opcion!=4);







    }
}

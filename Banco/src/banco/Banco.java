package banco;
import java.io.*;
/**
 * @author Rafael Mellado
 * rafael.mellado@pucv.cl
 * www.rafaelmellado.cl
 */
public class Banco 
{
    public static void main(String[] args) throws IOException 
    {
        /*Declaración e instanciación de nuestro arreglo*/
        CajaAhorro clientes[] = new CajaAhorro[100];
        
        /*Llenaremos 10 clientes*/
        BufferedReader lector = new  BufferedReader( new InputStreamReader( System.in ) );
        for(int i=0; i<10 && i<clientes.length; i++)
        {
            System.out.println("Ingrese el numero de la cuenta");
            int numeroCuenta = Integer.parseInt(lector.readLine());
            System.out.println("Ingrese el saldo inicial de la cuenta");
            int saldoInicial = Integer.parseInt(lector.readLine());
            
            CajaAhorro nuevoCliente = new CajaAhorro(numeroCuenta,saldoInicial);
            clientes[i]=nuevoCliente;
        }
        
        /*Se muestran los clientes asumiendo que quedaron compactos*/
        for(int i=0; i<clientes.length && clientes[i]!=null; i++)
        {
            System.out.println("Cuenta numero: "+clientes[i].obtenerSaldo());
            System.out.println("Saldo: $"+clientes[i].obtenerSaldo());
        }
    }
}

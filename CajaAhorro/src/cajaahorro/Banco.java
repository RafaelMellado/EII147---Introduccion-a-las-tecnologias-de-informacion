package cajaahorro;

/**
 * @author Rafael Mellado
 * rafael.mellado@pucv.cl
 * www.rafaelmellado.cl
 */
public class Banco 
{
    public static void main(String[] args) 
    {
        /*Crearemos dos cuentas*/
        CajaAhorro cuenta1;
        CajaAhorro cuenta2;
        
        /*Se instancia la clase CajaAhorro*/
        cuenta1= new CajaAhorro(2450003,1);
        cuenta2= new CajaAhorro(12552,1500);
        
        /*Se utilizan los métodos*/
        cuenta1.depositar(500);
        System.out.println("El saldo de la cuenta 1 es: "+cuenta1.obtenerSaldo());
        
        cuenta2.girar(500);
        System.out.println("El saldo de la cuenta 2 es: "+cuenta2.obtenerSaldo());
    }
}

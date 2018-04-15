package cajaahorro;

public class CajaAhorro 
{
    private int numeroCuenta;
    private int saldo;
    private int cantidadTransacciones;

    public CajaAhorro(int numeroCuenta, int saldo) 
    {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        cantidadTransacciones=0;
    }
    
    public void depositar(int monto)
    {
        saldo=saldo+monto;
        cantidadTransacciones++;
    }
    
    public void girar(int monto)
    {
        saldo=saldo-monto;
        cantidadTransacciones++;
    }
    
    public int obtenerSaldo()
    {
        return saldo;
    }
    
    public int obtenerCantidadTransacciones()
    {
        return cantidadTransacciones;
    }
}

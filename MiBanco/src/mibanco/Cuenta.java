package mibanco;

/**
 *
 * @author rafaelmellado
 */
public class Cuenta {
    private String rut;
    private String nombreCliente;
    private int numeroCuenta;
    private String direccion;
    private int saldoCuenta;
    private String codigoSeguridad;

    public Cuenta(String rut, String nombreCliente, int numeroCuenta, String direccion, int saldoCuenta, String codigoSeguridad) 
    {
        this.rut = rut;
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.direccion = direccion;
        this.saldoCuenta = saldoCuenta;
        this.codigoSeguridad = codigoSeguridad;
    }
    
    public Cuenta(String rut, String nombreCliente, int numeroCuenta, String direccion, int saldoCuenta) 
    {
        this.rut = rut;
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.direccion = direccion;
        this.saldoCuenta = saldoCuenta;
        this.codigoSeguridad = null;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(int saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
   
}

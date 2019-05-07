package mibanco;

/**
 *
 * @author rafaelmellado
 */
public class Sucursal {
    private int numeroSucursal;
    private String direccion;
    private String regionPais;
    private String nombreGerente;
    private Cuenta cuentas[];

    public Sucursal(int numeroSucursal, String direccion, String regionPais, String nombreGerente, int cantidadCuentas) {
        this.numeroSucursal = numeroSucursal;
        this.direccion = direccion;
        this.regionPais = regionPais;
        this.nombreGerente = nombreGerente;
        this.cuentas = new Cuenta[cantidadCuentas];
    }

    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(int numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRegionPais() {
        return regionPais;
    }

    public void setRegionPais(String regionPais) {
        this.regionPais = regionPais;
    }

    public String getNombreGerente() {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }
    
    public boolean buscarCuenta(String rut, int numeroCuenta)
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null && cuentas[i].getNumeroCuenta()==numeroCuenta && cuentas[i].getRut().equals(rut))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean agregarCuenta(Cuenta nuevo)
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]==null)
            {
                cuentas[i]=nuevo;
                return true;
            }
        }
        return false;
    }
    
    public void depositar(int numeroCuenta, String rut, int monto)
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null && cuentas[i].getNumeroCuenta()==numeroCuenta && cuentas[i].getRut().equals(rut))
            {
                cuentas[i].setSaldoCuenta(cuentas[i].getSaldoCuenta()+monto);
            }
        }
    }
    
    public boolean girar(int numeroCuenta, String rut, int monto)
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null && cuentas[i].getNumeroCuenta()==numeroCuenta && cuentas[i].getRut().equals(rut) && cuentas[i].getSaldoCuenta()>=monto)
            {
                cuentas[i].setSaldoCuenta(cuentas[i].getSaldoCuenta()-monto);
                return true;
            }
        }
        return false;
    }
    
    public boolean validarClaveCuenta(int numeroCuenta, String rut, String claveCuenta)
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null && cuentas[i].getNumeroCuenta()==numeroCuenta && cuentas[i].getRut().equals(rut) && cuentas[i].getCodigoSeguridad().equals(claveCuenta))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean existeEspacio()
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]==null)
            {
                return true;
            }
        }
        return false;
    }
    
    public Cuenta quitarCuenta(int numeroCuenta, String rut)
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null && cuentas[i].getNumeroCuenta()==numeroCuenta && cuentas[i].getRut().equals(rut))
            {
                Cuenta aux= cuentas[i];
                cuentas[i]=null;
                return aux;
            }
        }
        return null;
    }
    
    public boolean eliminarCuenta(int numeroCuenta, String rut)
    {
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null && cuentas[i].getNumeroCuenta()==numeroCuenta && cuentas[i].getRut().equals(rut))
            {
                cuentas[i]=null;
                return true;
            }
        }
        return false;
    }
    
    public int espaciosLibres()
    {
        int contador=0;
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]==null)
            {
                contador++;
            }
        }
        return cuentas.length-contador;
    }
    
    public int cantidadCuentasExistentes()
    {
        int contador=0;
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null)
            {
                contador++;
            }
        }
        return contador;
    }
    
    public Cuenta[] quitarCuentas()
    {
        if(cuentas.length-this.espaciosLibres()>0)
        {
            Cuenta respaldo[] = new Cuenta[cuentas.length-this.espaciosLibres()];
            int indice =0;
            
            /*SE LLENA EL RESPALDO*/
            for(int i=0; i<cuentas.length; i++)
            {
                if(cuentas[i]!=null)
                {
                    respaldo[indice]=cuentas[i];
                    cuentas[i]=null;
                    indice++;
                }
            }
            return respaldo;
        }
        return null;
    }
    
    public int sumatoriaSaldos()
    {
        int sumatoria=0;
        for(int i=0; i<cuentas.length; i++)
        {
            if(cuentas[i]!=null)
            {
                sumatoria+=cuentas[i].getSaldoCuenta();
            }
        }
        return sumatoria;
    }
    
    
    
    
   
    
    
}

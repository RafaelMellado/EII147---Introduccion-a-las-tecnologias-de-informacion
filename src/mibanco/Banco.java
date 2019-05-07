package mibanco;

/**
 *
 * @author rafaelmellado
 */
public class Banco {
    private String nombreGerente;
    private Sucursal sucursales[];

    public Banco(String nombreGerente, int cantidadSucursales) {
        this.nombreGerente = nombreGerente;
        this.sucursales = new Sucursal[cantidadSucursales];
    }

    public String getNombreGerente() {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }
    
    public boolean buscarCuenta(String rut, int numeroCuenta)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null ; i++)
        {
            if(sucursales[i].buscarCuenta(rut, numeroCuenta)==true)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean agregarCuenta(int numeroSucursal, Cuenta nuevo)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null ; i++)
        {
            if(sucursales[i].getNumeroSucursal()==numeroSucursal)
            {
                return sucursales[i].agregarCuenta(nuevo);
            }
        }
        return false;
    }
    
    public boolean depositar(int numeroCuenta, String rut, int monto)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].buscarCuenta(rut, numeroCuenta)==true)
            {
                sucursales[i].depositar(numeroCuenta, rut, monto);
                return true;
            }
        }
        return false;
    }
    
    public boolean depositar(int numeroCuenta, String rut, int monto, String claveCuenta)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].buscarCuenta(rut, numeroCuenta)==true && sucursales[i].validarClaveCuenta(numeroCuenta, rut, claveCuenta)==true)
            {
                sucursales[i].depositar(numeroCuenta, rut, monto);
                return true;
            }
        }
        return false;
    }
    
    public boolean girar(int numeroCuenta, String rut, int monto)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].buscarCuenta(rut, numeroCuenta)==true)
            {
                return sucursales[i].girar(numeroCuenta, rut, monto);
            }
        }
        return false;
    }
    
    public boolean girar(int numeroCuenta, String rut, int monto, String claveCuenta)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].buscarCuenta(rut, numeroCuenta)==true && sucursales[i].validarClaveCuenta(numeroCuenta, rut, claveCuenta)==true)
            {
                return sucursales[i].girar(numeroCuenta, rut, monto);
            }
        }
        return false;
    }
    
    public boolean moverCuentaDeSucursal(int numeroCuenta, String rut, int numeroSucursalOrigen, int numeroSucursalDestino)
    {
        /*BUSCAMOS LA SUCURSAL DE DESTINO*/
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].getNumeroSucursal()==numeroSucursalDestino && sucursales[i].existeEspacio()==true)
            {
                /*COMO TIENE ESPACIO Y LA ENCONTRAMOS AHORA SE SACA DEL ORIGEN*/
                for(int j=0; j<sucursales.length && sucursales[j]!=null; j++)
                {   
                    if(sucursales[j].getNumeroSucursal()==numeroSucursalOrigen && sucursales[j].buscarCuenta(rut, numeroCuenta)==true)
                    {
                        return sucursales[i].agregarCuenta(sucursales[j].quitarCuenta(numeroCuenta, rut));
                    }
                }    
            }
        }
        return false;
    }
    
    public int capacidadRegion(String region)
    {
        int sumatoria=0;
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].getRegionPais().equals(region))
            {
                sumatoria+=sucursales[i].espaciosLibres();
            }
        }
        return sumatoria;
    }
    
    
    public boolean eliminarSucursal(int numeroSucursal)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].getNumeroSucursal()==numeroSucursal)
            {
                sucursales[i]=null;
                return true;
            }
        }
        return false;
    }
    
    public boolean moverClientesSucursal(int numeroSucursal)
    {
        /*Verificar si hay destinos que puedan recibir que sean de la region*/
        
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].getNumeroSucursal()==numeroSucursal)
            {
                /*AHORA BUSCAMOS EL TOTAL QUE SUMAN LAS SUCURSALES CON LA MISMA REGION*/
                int sumaRegion=0;
                for(int j=0; j<sucursales.length && sucursales[j]!=null; j++)
                {
                    if(sucursales[i].getRegionPais().equals(sucursales[j].getRegionPais()))
                    {
                        sumaRegion+=sucursales[j].espaciosLibres();
                    }
                }
                sumaRegion=sumaRegion-sucursales[i].espaciosLibres();
                
                
                /*SI LAS OTRAS SUCURSALES DE MISMA REGION TIENEN ESPACIO*/
                if(sumaRegion>=sucursales[i].cantidadCuentasExistentes())
                {
                    Cuenta respaldo[]=sucursales[i].quitarCuentas();
                    for(int r=0; r<respaldo.length; r++)
                    {
                        boolean cuentaAgregada=false;
                        /*BUSCAMOS DONDE ASIGNAR DICHA CUENTA*/
                        for(int j=0; j<sucursales.length && sucursales[j]!=null && cuentaAgregada==false; j++)
                        {
                            if(sucursales[i]!=sucursales[j] && sucursales[i].getRegionPais().equals(sucursales[j].getRegionPais()) && sucursales[j].existeEspacio())
                            {
                                if(sucursales[j].agregarCuenta(respaldo[r])==true)
                                {
                                    cuentaAgregada=true;
                                }
                            }
                        }
                    }
                    return true;
                }
                else
                {
                    /*SI LAS SUCURSALES DE LA MISMA REGION NO TIENEN CAPACIDAD*/
                    
                    /*SUMAMOS TODAS LAS CAPACIDADES*/
                    int sumaEspacios=0;
                    for(int j=0; j<sucursales.length && sucursales[j]!=null; j++)
                    {
                        sumaEspacios+=sucursales[j].espaciosLibres();
                    }
                    sumaEspacios=sumaEspacios-sucursales[i].espaciosLibres();
                    
                    /*Si en las otras sucursales hay espacio*/
                    if(sumaEspacios>=sucursales[i].cantidadCuentasExistentes())
                    {
                        Cuenta respaldo[]=sucursales[i].quitarCuentas();
                        for(int r=0; r<respaldo.length; r++)
                        {
                            boolean cuentaAgregada=false;
                            for(int j=0; j<sucursales.length && sucursales[j]!=null && cuentaAgregada==false; j++)
                            {
                                if(sucursales[i]!=sucursales[j] && sucursales[j].existeEspacio())
                                {
                                    if(sucursales[j].agregarCuenta(respaldo[r])==true)
                                    {
                                        cuentaAgregada=true;
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public int numeroSucursalClientesPudientes()
    {
        int numeroSucursal=-1, saldoMayor=0;
        boolean primeraSucursal=true;
        
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(primeraSucursal==true || sucursales[i].sumatoriaSaldos()>saldoMayor)
            {
                primeraSucursal=false;
                saldoMayor=sucursales[i].sumatoriaSaldos();
                numeroSucursal=sucursales[i].getNumeroSucursal();
            }
        }
        return numeroSucursal;
    }
    
    public boolean eliminarCuenta(int numeroCuenta, String rut)
    {
        for(int i=0; i<sucursales.length && sucursales[i]!=null; i++)
        {
            if(sucursales[i].buscarCuenta(rut, numeroCuenta)==true)
            {
                return sucursales[i].eliminarCuenta(numeroCuenta, rut);
            }
        }
        return false;
    }
    
    
  
    
    
    
    
    
    
    
    
    
    
}

package mibanco;

/**
 *
 * @author rafaelmellado
 */
public class MiBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        /***** CREAMOS LA INSTANCIA DE BANCO*/
        Banco banquito = new Banco("Juan Nieve",100);
        
       
        /***** AGREGAR CLIENTE A UNA SUCURSAL*/
        Cuenta nueva;
        /*OPCION CON CLAVE*/
        nueva= new Cuenta("19.222.345-4", "Fernanda Fernandez", 76543213, "Av. Brasil 2241", 0, "666GTG53");
        if(banquito.agregarCuenta(10, nueva)==true)
        {
            System.out.println("Cuenta agregada");
        }
        else
        {
            System.out.println("No se pudo agregar la cuenta");
        }
        
        /*OPCION SIN CLAVE*/
        nueva= new Cuenta("19.222.345-4", "Fernanda Fernandez", 76543213, "Av. Brasil 2241", 0);
        if(banquito.agregarCuenta(10, nueva)==true)
        {
            System.out.println("Cuenta agregada");
        }
        else
        {
            System.out.println("No se pudo agregar la cuenta");
        }
        
        
        /***** DEPOSITAR*/
        int monto=10000;
        
        /*CON CLAVE*/
        if(monto>0)
        {
            if(banquito.depositar(76543213,"19.222.345-4",monto,"666GTG53")==true)
            {
                System.out.println("Depositado!");
            }
        }
 
        /*SIN CLAVE*/
        if(monto>0)
        {
            if(banquito.depositar(76543213,"19.222.345-4",monto)==true)
            {
                System.out.println("Depositado!");
            }
        }
        

        /***** GIRAR*/
        monto=5000;
        
        /*CON CLAVE*/
        if(monto>0)
        {
            if(banquito.girar(76543213,"19.222.345-4",monto,"666GTG53")==true)
            {
                System.out.println("Giro exitoso!");
            }
        }
 
        /*SIN CLAVE*/
        if(monto>0)
        {
            if(banquito.girar(76543213,"19.222.345-4",monto)==true)
            {
                System.out.println("Giro exitoso!");
            }
        }
        

        /***** MOVER CLIENTE DE SUCURSAL*/
        if(banquito.moverCuentaDeSucursal(76543213, "19.222.345-4", 10, 11)==true)
        {
            System.out.println("Cliente movido");
        }
        else
        {
            System.out.println("No se puede mover");
        }
        

        /***** ELIMINAR SUCURSAL*/
        if(banquito.moverClientesSucursal(10)==true)
        {
            if(banquito.eliminarSucursal(10)==true)
            {
                System.out.println("Sucursal eliminado");
            }
            else
            {
                System.out.println("No se puede eliminar");
            }
        }

        
        /***** SUCURSAL CON CLIENTES MAS PUDIENTES*/
        if(banquito.numeroSucursalClientesPudientes()!=-1)
        {
            System.out.println("El numero de sucursal con clientes mas pudientes es: "+banquito.numeroSucursalClientesPudientes());
        }

        
        /***** ELIMINAR CUENTA*/
        if(banquito.eliminarCuenta(76543213, "19.222.345-4")==true)
        {
            System.out.println("Cliente eliminado");
        }
        else
        {
            System.out.println("No se puede eliminar cliente");
        }
          
    }
    
}

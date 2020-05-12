package javaapplication25;

public class SistemaCovid 
{
    public Region regiones[];
    
    public SistemaCovid(int cantidadRegiones)
    {
        regiones=new Region[cantidadRegiones];
    }
    
    public boolean buscarPaciente(String rut)
    {
        for(int i=0; i<regiones.length; i++)
        {
            if(regiones[i]!=null && regiones[i].buscarPaciente(rut)==true)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean agregarPaciente(Paciente nuevo, int numeroRegion)
    {
        if(buscarPaciente(nuevo.getRut())==false)
        {
            for(int i=0; i<regiones.length; i++)
            {
                if(regiones[i]!=null && regiones[i].getNumero()==numeroRegion)
                {
                    return regiones[i].agregarPaciente(nuevo);
                }
            }
        }
        return false;
    }
    
    public boolean agregarPaciente(String nombre, String apellido, String rut, int edad, int numeroADN, int numeroRegion)
    {
        Paciente nuevo=new Paciente(nombre, apellido, rut, edad, numeroADN);
        
        return this.agregarPaciente(nuevo, numeroRegion);
    }
    
    public boolean agregarPaciente(String nombre, String apellido, String rut, int edad, int numeroRegion)
    {
        return this.agregarPaciente(new Paciente(nombre, apellido, rut, edad),numeroRegion);
    }
    
    public void quitarInfectados(int edad)
    {
        for(int i=0; i<regiones.length; i++)
        {
            if(regiones[i]!=null)
            {
                regiones[i].quitarInfectados(edad);
            }
        }
    }
    
    
    
}

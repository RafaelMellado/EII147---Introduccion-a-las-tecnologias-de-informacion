package javaapplication25;

public class ListaPacientes 
{
    private Paciente pacientes[];
    
    public ListaPacientes (int cantPacientes)
    {
        pacientes=new Paciente[cantPacientes];
    }
    
    public boolean buscarPaciente(String rut)
    {
        for(int i=0; i<pacientes.length; i++)
        {
            if(pacientes[i]!=null && pacientes[i].getRut().equals(rut))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean agregarPaciente(Paciente nuevo)
    {
        for(int i=0; i<pacientes.length; i++)
        {
            if(pacientes[i]==null)
            {
                pacientes[i]=nuevo;
                return true;
            }
        }
        return false;
    }
    
    public void quitarInfectados(int edad)
    {
        for(int i=0; i<pacientes.length; i++)
        {
            if(pacientes[i]!=null && pacientes[i].getEdad()>edad)
            {
                pacientes[i]=null;
            }
        }
    }
    
    
    
}

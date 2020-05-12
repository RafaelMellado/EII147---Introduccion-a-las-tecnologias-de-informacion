package javaapplication25;

public class Region 
{
    private int numero;
    private String nombre;
    private ListaPacientes pacientes;
    
    public Region (int numero, String nombre, int cantidadPacientes)
    {
        this.numero=numero;
        this.nombre=nombre;
        pacientes=new ListaPacientes(cantidadPacientes);
    }
    
    public Region (int numero, String nombre)
    {
        this.numero=numero;
        this.nombre=nombre;
        pacientes=null;
    }
    
    public int getNumero()
    {
        return numero;
    }
    
    public void crearListaPacientes(int cantidadPacientes)
    {
        pacientes=new ListaPacientes(cantidadPacientes);
    }
    
    public boolean buscarPaciente(String rut)
    {
        return pacientes.buscarPaciente(rut);
    }
    
    public boolean agregarPaciente(Paciente nuevo)
    {
        return pacientes.agregarPaciente(nuevo);
    }
    
    public void quitarInfectados(int edad)
    {
        pacientes.quitarInfectados(edad);
    }
    
}

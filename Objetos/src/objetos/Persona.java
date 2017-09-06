package objetos;

public class Persona 
{
    private String rut;
    private String nombre;
    private int edad;

    public Persona(String rut, String nombre, int edad)
    {
        this.rut=rut;
        this.nombre=nombre;
        this.edad=edad;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getEdad()
    {
        return edad;
    }
    
    public void setNombre(String nombreNuevo)
    {
        nombre=nombreNuevo;
    }
    
    
    
}

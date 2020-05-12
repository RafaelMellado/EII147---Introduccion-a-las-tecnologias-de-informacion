package javaapplication25;

public class Paciente 
{
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;
    private int numeroADN;
    
    public Paciente(String nombre, String apellido, String rut, int edad, int numeroADN)
    {
        this.nombre=nombre;
        this.apellido=apellido;
        this.rut=rut;
        this.edad=edad;
        this.numeroADN=numeroADN;
    }
    
    public Paciente(String nombre, String apellido, String rut, int edad)
    {
        this.nombre=nombre;
        this.apellido=apellido;
        this.rut=rut;
        this.edad=edad;
        this.numeroADN=-1;
    }
    
    public double calcularPeligrosidad(double indicaGlobal, int año)
    {
        double peligrosidad;
        peligrosidad = indicaGlobal*numeroADN/año;
        return peligrosidad;
    }
    
    public double calcularPeligrosidad(int año)
    {
        return año/0.19;
    }
    
    
    public String getRut()
    {
        return rut;
    }
    
    public int getEdad()
    {
        return edad;
    }
    
}

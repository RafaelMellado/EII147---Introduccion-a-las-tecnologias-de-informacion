package colegio;

public class Alumno 
{
    private int numeroUnico;
    private String nombre;
    private double promedio;
    
    public Alumno(int numeroUnico, String nombre, double promedio)
    {
        this.numeroUnico=numeroUnico;
        this.nombre=nombre;
        this.promedio=promedio;
    }
    
    public int getNumeroUnico()
    {
        return numeroUnico;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public double getPromedio()
    {
        return promedio;
    }
    
}

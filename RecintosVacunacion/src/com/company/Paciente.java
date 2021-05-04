package com.company;

public class Paciente
{
    private String rut;
    private String nombre;
    private String direccion;
    private int edad;

    public Paciente(String rut, String nombre, String direccion, int edad)
    {
        this.rut=rut;
        this.nombre=nombre;
        this.direccion=direccion;
        this.edad=edad;
    }

    public String getRut()
    {
        return rut;
    }

}

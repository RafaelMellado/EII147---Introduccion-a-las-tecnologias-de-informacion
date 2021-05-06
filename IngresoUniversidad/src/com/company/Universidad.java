package com.company;

public class Universidad
{
    private String rut;
    private String nombre;
    private String direccion;
    private Carrera carreras[];

    public Universidad(String rut, String nombre, String direccion, int cantidadCarreras)
    {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.carreras=new Carrera[cantidadCarreras];
    }

    public String getRut()
    {
        return rut;
    }
}

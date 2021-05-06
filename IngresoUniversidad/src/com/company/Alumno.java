package com.company;

public class Alumno 
{
    private String rut;
    private String nombre;
    private int edad;
    private double puntajePTU;
    private double NEM;
    private String deportePracticado;

    public Alumno(String rut, String nombre, int edad, double puntajePTU, double NEM)
    {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.puntajePTU=puntajePTU;
        this.NEM=NEM;
        this.deportePracticado=null;
    }

    public Alumno(String rut, String nombre, int edad, double NEM, String deportePracticado)
    {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.puntajePTU=0;
        this.NEM=NEM;
        this.deportePracticado=deportePracticado;
    }
}


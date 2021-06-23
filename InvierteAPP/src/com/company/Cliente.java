package com.company;

public class Cliente
{
    private String rut;
    private String nombre;
    private Inversion inversiones[];
    private int pLibre;

    public Cliente(String rut, String nombre, int cantInversiones)
    {
        this.rut = rut;
        this.nombre = nombre;
        this.inversiones = new Inversion[cantInversiones];
        this.pLibre=0;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

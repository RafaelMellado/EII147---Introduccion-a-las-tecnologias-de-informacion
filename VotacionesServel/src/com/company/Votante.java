package com.company;

public class Votante
{
    private String rut;
    private String nombre;
    private int edad;
    private Constituyente votoConstituyente;
    private Gobernador votoGobernador;

    public Votante(String rut, String nombre, int edad, Constituyente votoConstituyente, Gobernador votoGobernador)
    {
        this.rut=rut;
        this.nombre=nombre;
        this.edad=edad;
        this.votoConstituyente=votoConstituyente;
        this.votoGobernador=votoGobernador;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Constituyente getVotoConstituyente() {
        return votoConstituyente;
    }

    public Gobernador getVotoGobernador() {
        return votoGobernador;
    }
}

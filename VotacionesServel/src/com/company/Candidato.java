package com.company;

public abstract class Candidato
{
    private int id;
    private String nombre;
    private String partidoPolitico;

    public Candidato(int id, String nombre, String partidoPolitico)
    {
        this.id = id;
        this.nombre = nombre;
        this.partidoPolitico = partidoPolitico;
    }

    public abstract double calcularProbidad(double indicadorPais, int cantidadVotos);

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }
}

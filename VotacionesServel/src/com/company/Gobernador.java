package com.company;

public class Gobernador extends Candidato
{
    private String regionPostulada;

    public Gobernador(int id, String nombre, String partidoPolitico, String regionPostulada)
    {
        super(id, nombre, partidoPolitico);
        this.regionPostulada=regionPostulada;
    }

    public double calcularProbidad(double indicadorPais, int cantidadVotos)
    {
        return (indicadorPais*100)-cantidadVotos;
    }




}

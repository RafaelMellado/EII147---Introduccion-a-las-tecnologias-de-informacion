package com.company;

public class Constituyente extends Candidato
{
    private int numeroDistrito;

    public Constituyente(int numeroDistrito, String nombre, int id, String partidoPolitico)
    {
        super(id, nombre, partidoPolitico);
        this.numeroDistrito = numeroDistrito;
    }

    public double calcularProbidad(double indicadorPais, int cantidadVotos)
    {
        if(indicadorPais>0)
            return cantidadVotos/indicadorPais;
        return 0;
    }

}

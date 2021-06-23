package com.company;

public class FondoFijo extends FondoInversion
{
    private double comision;

    public FondoFijo(int id, String nombre, String pais, double valorFondo, double comision)
    {
        super(id, nombre, pais, valorFondo);
        this.comision = comision;
    }

    public double calcularComision(int cantidadCuotas)
    {
        if(cantidadCuotas>0)
            return (cantidadCuotas*getValorCuota())-comision;
        return 0;
    }


}

package com.company;

public class FondoVariable extends FondoInversion
{
    private double porcentajeComision;

    public FondoVariable(int id, String nombre, String pais, double valorFondo, double porcentajeComision)
    {
        super(id, nombre, pais, valorFondo);
        this.porcentajeComision = porcentajeComision;
    }

    public double calcularComision(int cantidadCuotas)
    {
        if(cantidadCuotas>0)
        {
            double montoComision=(getValorCuota()*cantidadCuotas)*(porcentajeComision/100);
            return (getValorCuota()*cantidadCuotas)-montoComision;
        }
        return 0;
    }
}

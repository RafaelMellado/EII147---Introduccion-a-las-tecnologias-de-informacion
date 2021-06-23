package com.company;

public abstract class FondoInversion
{
    private int id;
    private String nombre;
    private String pais;
    private double valorCuota;

    public FondoInversion(int id, String nombre, String pais, double valorCuota)
    {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.valorCuota = valorCuota;
    }

    public abstract double calcularComision(int cantidadCuotas);

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public double getValorCuota() {
        return valorCuota;
    }
}

package com.company;

public class InvierteAPP
{
    private ListaClientes clientes;
    private ListaFondos fondos;

    public InvierteAPP()
    {
        this.clientes = new ListaClientes();
        this.fondos = new ListaFondos();
    }

    public boolean agregarFondo(FondoInversion fondoNuevo)
    {
        return fondos.agregarFondo(fondoNuevo);
    }
}

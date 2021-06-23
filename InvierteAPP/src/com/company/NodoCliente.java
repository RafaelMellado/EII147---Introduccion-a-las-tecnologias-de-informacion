package com.company;

public class NodoCliente
{
    private Cliente cliente;
    private NodoCliente sig;

    public NodoCliente(Cliente cliente, NodoCliente sig)
    {
        this.cliente = cliente;
        this.sig = sig;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoCliente getSig() {
        return sig;
    }

    public void setSig(NodoCliente sig) {
        this.sig = sig;
    }
}

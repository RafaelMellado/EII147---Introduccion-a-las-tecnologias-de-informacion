package com.company;

public class NodoFondo
{
    private FondoInversion fondo;
    private NodoFondo siguiente;

    public NodoFondo(FondoInversion fondo, NodoFondo siguiente)
    {
        this.fondo=fondo;
        this.siguiente= siguiente;
    }

    public NodoFondo()
    {
        fondo=null;
        siguiente=null;
    }

    public FondoInversion getFondo()
    {
        return fondo;
    }

    public NodoFondo getSiguiente() {
        return siguiente;
    }

    public void setFondo(FondoInversion nuevoFondo)
    {
        if(nuevoFondo!=null)
            this.fondo=nuevoFondo;
    }

    public void setSiguiente(NodoFondo siguiente)
    {
        this.siguiente=siguiente;
    }
}

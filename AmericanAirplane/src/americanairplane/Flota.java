package americanairplane;

public class Flota 
{
    private Avion flota[];
    private int cantidadAviones;

    public Flota(int tamañoFlota) 
    {
        flota=new Avion[tamañoFlota];
        cantidadAviones=0;
    }
}

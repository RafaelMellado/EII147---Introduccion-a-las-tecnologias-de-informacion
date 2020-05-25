package americanairplane;

public class LineaAerea 
{
    private String nombre;
    private Flota flota;
    private ListaPasajeros pasajeros;

    public LineaAerea(String nombre, int tamañoFlota, int cantidadPasajeros) 
    {
        this.nombre = nombre;
        this.flota = new Flota(tamañoFlota);
        this.pasajeros= new ListaPasajeros(cantidadPasajeros);
    }
    
    
    
}

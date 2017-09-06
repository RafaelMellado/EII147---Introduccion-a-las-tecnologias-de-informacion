package objetos;

public class Objetos 
{ 
    public static void main(String[] args) 
    {
       Persona profesor;
       
       profesor= new Persona("18765678-8","Juan Perez",25);
       Persona director= new Persona("12345653-0","Francisco Parra", 30);
       
       String nombre = profesor.getNombre();
       System.out.println("El profesor se llama: "+nombre);
       System.out.println("Su edad es: "+profesor.getEdad());
       
       profesor.setNombre("Marcelo Fernandez");
       
        System.out.println("El profesor se llama ahora: "+profesor.getNombre());
        System.out.println("EL director se llama:"+director.getNombre());
       
       
    }
    
}

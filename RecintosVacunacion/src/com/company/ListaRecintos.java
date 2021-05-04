package com.company;

public class ListaRecintos
{
    private Recinto recintos[];
    private int pLibre;

    public ListaRecintos(int cantidadRecintos)
    {
        this.recintos=new Recinto[cantidadRecintos];
        pLibre=0;
    }

    public boolean agregarPaciente(String nombreRecinto, Paciente nuevo)
    {
        for(int i=0; i<pLibre; i++)
        {
            if(recintos[i].getNombre().equals(nombreRecinto))
                return recintos[i].agregarPaciente(nuevo);
        }
        return false;
    }

    public int eliminarPaciente(String rutPaciente)
    {
        int contador=0;
        for(int i=0; i<pLibre; i++)
        {
            if(recintos[i].eliminarPaciente(rutPaciente)==true)
                contador++;
        }
        return contador;
    }

    public String getNombreRecintoMasPacientes()
    {
        Recinto recintoMayor=null;

        for(int i=0; i<pLibre; i++)
        {
            if(recintoMayor==null || recintos[i].contarPacientes()>recintoMayor.contarPacientes())
                recintoMayor=recintos[i];
        }

        if(recintoMayor!=null)
            return recintoMayor.getNombre();
        return null;
    }


    public boolean trasladarPaciente(String rutPaciente, String nombreRecintoOrigen, String nombreRecintoDestino)
    {
        Recinto origen=null, destino=null;

        for(int i=0; i<pLibre; i++) {
            if (origen == null && recintos[i].getNombre().equals(nombreRecintoOrigen))
                origen = recintos[i];

            if (destino == null && recintos[i].getNombre().equals(nombreRecintoDestino))
                destino = recintos[i];
        }

        if(origen!=null && destino!=null && origen.buscarPaciente(rutPaciente)==true && destino.buscarPaciente(rutPaciente)==false)
                return destino.agregarPaciente(origen.quitarPaciente(rutPaciente));
        return false;
    }


}

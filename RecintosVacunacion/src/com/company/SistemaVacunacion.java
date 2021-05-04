package com.company;

public class SistemaVacunacion
{
    private String nombreEncargado;
    private ListaRecintos recintos;

    public SistemaVacunacion(String nombreEncargado, int cantidadRecintos)
    {
        this.nombreEncargado=nombreEncargado;
        this.recintos=new ListaRecintos(cantidadRecintos);
    }

    public boolean agregarPaciente(String nombreRecinto, Paciente nuevoPaciente)
    {
        return recintos.agregarPaciente(nombreRecinto,nuevoPaciente);
    }

    public int eliminarPaciente(String rutPaciente)
    {
        return recintos.eliminarPaciente(rutPaciente);
    }

    public boolean trasladarPaciente(String rutPaciente, String nombreRecintoOrigen, String nombreRecintoDestino)
    {
        return recintos.trasladarPaciente(rutPaciente, nombreRecintoOrigen, nombreRecintoDestino);
    }


}

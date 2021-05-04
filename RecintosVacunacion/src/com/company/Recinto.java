package com.company;

public class Recinto
{
    private String nombre;
    private String direccion;
    private Paciente pacientes[];

    public Recinto(String nombre, String direccion, int cantidadPacientes)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pacientes = new Paciente[cantidadPacientes];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean buscarPaciente(String rut)
    {
        for(int i=0; i<pacientes.length; i++)
        {
            if(pacientes[i]!=null && pacientes[i].getRut().equals(rut))
                return true;
        }
        return false;
    }


    public boolean agregarPaciente(String rut, String nombre, String direccion, int edad)
    {
        if(buscarPaciente(rut)==false)
        {
            for(int i=0; i<pacientes.length; i++)
            {
                if(pacientes[i]==null)
                {
                    pacientes[i]=new Paciente(rut,nombre,direccion,edad);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean agregarPaciente(Paciente nuevo)
    {
        if(nuevo!=null && buscarPaciente(nuevo.getRut())==false)
        {
            for(int i=0; i<pacientes.length; i++)
            {
                if(pacientes[i]==null)
                {
                    pacientes[i]=nuevo;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean eliminarPaciente(String rutPaciente)
    {
        for(int i=0; i<pacientes.length; i++)
        {
            if(pacientes[i]!=null && pacientes[i].getRut().equals(rutPaciente))
            {
                pacientes[i]=null;
                return true;
            }
        }
        return false;
    }

    public int contarPacientes()
    {
        int contador=0;
        for(int i=0; i<pacientes.length; i++) {
            if (pacientes[i] != null)
                contador++;
        }
        return contador;
    }

    public Paciente quitarPaciente(String rut)
    {
        for(int i=0; i<pacientes.length; i++)
        {
            if(pacientes[i] != null && pacientes[i].getRut().equals(rut))
            {
                Paciente eliminado = pacientes[i];
                pacientes[i]=null;
                return eliminado;
            }
        }
        return null;
    }








}

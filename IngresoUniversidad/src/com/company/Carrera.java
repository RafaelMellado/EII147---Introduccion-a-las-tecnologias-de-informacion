package com.company;

public class Carrera
{
    private int id;
    private String nombre;
    private Alumno alumnos[];
    int pLibreAlumnosPTU;
    int pLibreAlumnosIngresoEspecial;

    public Carrera(int id, String nombre, int cantidadMaximaAlumnos)
    {
        this.id = id;
        this.nombre = nombre;
        alumnos=new Alumno[cantidadMaximaAlumnos];
        pLibreAlumnosPTU=0;
        pLibreAlumnosIngresoEspecial=cantidadMaximaAlumnos-1;
    }


}

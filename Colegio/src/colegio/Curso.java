package colegio;

public class Curso 
{
    private int id;
    private String nombreProfesorJefe;
    private Alumno alumnos[];

    public Curso(int id, String nombreProfesorJefe, int cantidadAlumnos) {
        this.id = id;
        this.nombreProfesorJefe = nombreProfesorJefe;
        alumnos=new Alumno[cantidadAlumnos];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProfesorJefe() {
        return nombreProfesorJefe;
    }

    public void setNombreProfesorJefe(String nombreProfesorJefe) {
        this.nombreProfesorJefe = nombreProfesorJefe;
    }
    
    public boolean buscarAlumno(int numeroUnico)
    {
        for(int i=0; i<alumnos.length; i++)
        {
            if(alumnos[i]!=null && alumnos[i].getNumeroUnico()==numeroUnico)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean agregarAlumno(Alumno nuevo)
    {
        if(buscarAlumno(nuevo.getNumeroUnico())==false)
        {
            for(int i=0; i<alumnos.length; i++)
            {
                if(alumnos[i]==null)
                {
                    alumnos[i]=nuevo;
                    return true;
                }
            }
        }
        return false;
    }
    
}

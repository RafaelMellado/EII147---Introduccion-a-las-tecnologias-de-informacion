package com.company;

public class Region
{
    private int numero;
    private String nombre;
    private Votante votantes[];

    public Region(int numero, String nombre, int cantidadVotantes)
    {
        this.numero = numero;
        this.nombre = nombre;
        this.votantes = new Votante[cantidadVotantes];
    }

    public int contarVotosCandidatoGobernador(int idCandidato)
    {
        int contadorVotos=0;
        for(int i=0; i<votantes.length; i++)
        {
            if(votantes[i]!=null)
            {
                if(votantes[i].getVotoGobernador()!=null && votantes[i].getVotoGobernador().getId()==idCandidato)
                        contadorVotos++;
            }
        }
        return contadorVotos;
    }

    public int contarVotosConstituyente(int idCandidato)
    {
        int contadorVotos=0;
        for(int i=0; i<votantes.length; i++)
        {
            if(votantes[i]!=null)
            {
                if(votantes[i].getVotoConstituyente()!=null && votantes[i].getVotoConstituyente().getId()==idCandidato)
                    contadorVotos++;
            }
        }
        return contadorVotos;
    }

    public int getVotosTotales()
    {
        int contadorVotos=0;
        for(int i=0; i<votantes.length; i++)
        {
            if(votantes[i]!=null)
                contadorVotos++;
        }
        return contadorVotos;
    }





}

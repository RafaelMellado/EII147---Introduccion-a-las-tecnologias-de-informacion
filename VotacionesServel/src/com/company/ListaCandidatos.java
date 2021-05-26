package com.company;

public class ListaCandidatos
{
    private Candidato candidatos[];

    public ListaCandidatos(int cantMaxCandidatos)
    {
        candidatos=new Candidato[cantMaxCandidatos];
    }

    public boolean existeCandidato(int idCandidato)
    {
        for(int i=0; i<candidatos.length && candidatos[i]!=null; i++)
        {
            if(candidatos[i].getId()==idCandidato)
                return true;
        }
        return false;
    }

    public boolean validarSiEsGobernador(int idCandidato)
    {
        for(int i=0; i<candidatos.length && candidatos[i]!=null; i++)
        {
            if(candidatos[i].getId()==idCandidato && candidatos[i] instanceof Gobernador)
                return true;
        }
        return false;
    }

    public int contarGobernadores()
    {
        int contadorGobernadores=0;
        for(int i=0; i<candidatos.length && candidatos[i]!=null; i++)
        {
            if(candidatos[i] instanceof Gobernador)
                contadorGobernadores++;
        }
        return contadorGobernadores;
    }

    public int contarConstituyentes()
    {
        int contadorConstituyentes=0;
        for(int i=0; i<candidatos.length && candidatos[i]!=null; i++)
        {
            if(candidatos[i] instanceof Constituyente)
                contadorConstituyentes++;
        }
        return contadorConstituyentes;
    }

    public int[] getIdsGobernadores()
    {
        int idsGobernadores[] = new int[contarGobernadores()];
        if(idsGobernadores.length>0)
        {
            int indiceGobernador=0;
            for(int i=0; i<candidatos.length && candidatos[i]!=null; i++)
            {
                if(candidatos[i] instanceof Gobernador)
                {
                    idsGobernadores[indiceGobernador]=candidatos[i].getId();
                    indiceGobernador++;
                }
            }
        }
        return idsGobernadores;
    }

    public String[] getNombresConstituyentes()
    {
        if(this.contarConstituyentes()>0)
        {
            String nombresCandidatos[] = new String[this.contarConstituyentes()];
            int indiceConstituyente=0;
            for(int i=0; i<candidatos.length && candidatos[i]!=null; i++)
            {
                if(candidatos[i] instanceof Constituyente)
                {
                    nombresCandidatos[indiceConstituyente]=candidatos[i].getNombre();
                    indiceConstituyente++;
                }
            }
            return nombresCandidatos;
        }
        return null;
    }











}

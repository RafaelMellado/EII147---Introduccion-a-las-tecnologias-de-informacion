package com.company;

public class Servel
{
    private String nombreDirector;
    private ListaCandidatos postulantes;
    private Region regiones[];
    private int pLibreRegiones;

    public Servel(String nombreDirector, int cantMaxCandidatos, int cantidadRegiones)
    {
        this.nombreDirector = nombreDirector;
        this.postulantes = new ListaCandidatos(cantMaxCandidatos);
        this.regiones = new Region[cantidadRegiones];
        this.pLibreRegiones=0;
    }

    public int contarVotosGobernador(int idCandidato)
    {
        int contadorVotos=0;
        for(int i=0; i<pLibreRegiones; i++)
        {
            contadorVotos+=regiones[i].contarVotosCandidatoGobernador(idCandidato);
        }
        return contadorVotos;
    }

    public int contarVotosConstituyente(int idCandidato)
    {
        int contadorVotos=0;
        for(int i=0; i<pLibreRegiones; i++)
        {
            contadorVotos+=regiones[i].contarVotosConstituyente(idCandidato);
        }
        return contadorVotos;
    }

    public int getVotosTotales()
    {
        int contadorVotos=0;
        for(int i=0; i<pLibreRegiones; i++)
            contadorVotos+=regiones[i].getVotosTotales();
        return contadorVotos;
    }

    public double calcularPorcentajeVotos(int idCandidato)
    {
        if(postulantes.existeCandidato(idCandidato)==true && getVotosTotales()>0)
        {
            if(postulantes.validarSiEsGobernador(idCandidato)==true)
            {
                return (((double)contarVotosGobernador(idCandidato))/getVotosTotales())*100;
            }
            else
            {
                return (((double)contarVotosConstituyente(idCandidato))/getVotosTotales())*100;
            }
        }
        return 0;
    }

    public int idGobernadorGanador()
    {
        if(postulantes.contarGobernadores()>0)
        {
            int gobernadores[] = postulantes.getIdsGobernadores();

            if(gobernadores.length>0)
            {
                int gobernadorGanador=gobernadores[0];
                int cantidadVotosGanador=this.contarVotosGobernador(gobernadores[0]);

                for(int i=1; i<gobernadores.length; i++)
                {
                    if(this.contarVotosGobernador(gobernadores[i])>cantidadVotosGanador)
                    {
                        gobernadorGanador=gobernadores[i];
                        cantidadVotosGanador=this.contarVotosGobernador(gobernadorGanador);
                    }
                }
                return gobernadorGanador;
            }
        }
        return -1;
    }

    public String[] getNombreConstituyentes()
    {
        if(postulantes.contarConstituyentes()>0)
            return postulantes.getNombresConstituyentes();
        return null;
    }





}

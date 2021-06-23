package com.company;

public class ListaFondos
{
    private NodoFondo headFondos;

    public ListaFondos()
    {
        headFondos = new NodoFondo(null, null);
    }

    public boolean buscarFondo(int idFondoBuscado)
    {
        NodoFondo rec=headFondos.getSiguiente();

        while(rec!=null)
        {
            if(rec.getFondo().getId()==idFondoBuscado)
                return true;
            rec=rec.getSiguiente();
        }
        return false;
    }

    public boolean agregarFondo(FondoInversion fondoNuevo)
    {
        if(fondoNuevo!=null && buscarFondo(fondoNuevo.getId())==false)
        {
            NodoFondo rec=headFondos;

            while(rec.getSiguiente()!=null)
                rec=rec.getSiguiente();

            rec.setSiguiente(new NodoFondo(fondoNuevo, null));
            return true;
        }
        return false;
    }
    
    
    public boolean existeFondoEnArreglo(int []idsFondos, int idFondoBuscado)
    {
        for(int i=0; i<idsFondos.length; i++)
        {
            if(idsFondos[i]==idFondoBuscado)
                return true;
        }
        return false;
    }
    
    public int[] getIdsMayoresFondos()
    {
        int[] idsFondos = new int[10];


        FondoInversion mayor=headFondos.getSiguiente().getFondo();
        if(mayor!=null)
        {
            /*BUSCAR EL MAYOR*/
            NodoFondo rec= headFondos.getSiguiente();
            while(rec!=null)
            {
                if(rec.getFondo().getValorCuota()> mayor.getValorCuota())
                    mayor = rec.getFondo();

                rec=rec.getSiguiente();
            }

            /*LLENAREMOS EL ARREGLO CON LOS MAYORES*/
            int indiceLlenado=0;
            double valorCuotaActual=mayor.getValorCuota();

            while(indiceLlenado<idsFondos.length && valorCuotaActual>0)
            {
                rec=headFondos.getSiguiente();

                while(rec!=null)
                {
                    if(Math.abs(rec.getFondo().getValorCuota()-valorCuotaActual)<0.0000001 && existeFondoEnArreglo(idsFondos,rec.getFondo().getId())==false)
                    {
                        idsFondos[indiceLlenado]=rec.getFondo().getId();
                        indiceLlenado++;
                    }
                    rec=rec.getSiguiente();
                }
                valorCuotaActual--;
            }

            return idsFondos;
        }
        return null;
    }
}

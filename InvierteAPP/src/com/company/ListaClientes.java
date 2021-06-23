package com.company;

public class ListaClientes
{
    private NodoCliente clientes;

    public ListaClientes()
    {
        this.clientes=null;
    }

    public boolean buscarCliente(String rutCliente)
    {
        NodoCliente rec=clientes;

        while(rec!=null)
        {
            if(rec.getCliente().getRut().equals(rutCliente)==true)
                return true;
            rec=rec.getSig();
        }
        return false;
    }

    public boolean eliminarCliente(String rutCliente)
    {
        if(clientes!=null)
        {
            /*Caso 1: Es el head*/
            if(clientes.getCliente().getRut().equals(rutCliente)==true)
            {
                this.clientes=this.clientes.getSig();
            }

            /*Caso 2: Es otro elemento de la lista*/
            NodoCliente rec = clientes;

            while(rec.getSig()!=null)
            {
                if(rec.getSig().getCliente().getRut().equals(rutCliente)==true)
                {
                    rec.setSig(rec.getSig().getSig());
                    return true;
                }
                rec=rec.getSig();
            }
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarealistascirculares;

/**
 *
 * @author Adrian
 */
public class LCAdrian {

    public static void main(String[] args) {
        ListaCircular LCircular = new ListaCircular();
        LCircular.AgregarNodoInicio("3");
        LCircular.AgregarNodoInicio("2");
        LCircular.AgregarNodoInicio("1");
        LCircular.AgregaNodoFinal("4");
        LCircular.AgregarNodoPos("12", 3);
        LCircular.AgregarNodoPos("20", 13);
        LCircular.ImprimirListaCircular();
    }
}

class NodoCircular {

    public Object Dato;
    public NodoCircular Siguiente;
    public NodoCircular Anterior;

    /*
     * Constructor
     */
    public NodoCircular(String dato) {
        Dato = dato;
        Siguiente = null;
        Anterior = null;
    }
}

class ListaCircular {

    public NodoCircular PrimerNodo;

    public ListaCircular() {
        PrimerNodo = null;
    }

    public void ImprimirListaCircular()
    {
        if(PrimerNodo == null)
        {
            System.out.println("ERROR: La lista esta vacia");
        }
        else if(PrimerNodo.Siguiente == PrimerNodo)
        {
            System.out.println(PrimerNodo.Dato);
        }
        else
        {
            NodoCircular tmp = PrimerNodo;
            while(tmp.Siguiente != PrimerNodo)
            {
                System.out.print(tmp.Dato+" ");
                tmp = tmp.Siguiente;
            }
            System.out.println(tmp.Dato);
        }
    }
    
    /*
     * Agrega un nodo al inicio de la lista
     */
    public void AgregarNodoInicio(String dato) {
        NodoCircular tmp = new NodoCircular(dato);
        if (PrimerNodo == null) {
            tmp.Siguiente = tmp;
            tmp.Anterior = tmp;
            PrimerNodo = tmp;
        }
        else {
            tmp.Siguiente = PrimerNodo;
            PrimerNodo.Anterior = tmp;
            NodoCircular nodoTmp = PrimerNodo;
            while (nodoTmp.Siguiente != PrimerNodo)
            {
                nodoTmp = nodoTmp.Siguiente;
            }
            nodoTmp.Siguiente = tmp;
            tmp.Anterior = nodoTmp;

            PrimerNodo = tmp;
        }
    }

    /*
    * Agrega un nodo al final de la lista circular
    */
    public void AgregaNodoFinal(String dato)
    {
        NodoCircular nuevoNodo = new NodoCircular(dato);
        if (PrimerNodo == null)
        {
            nuevoNodo.Siguiente = nuevoNodo;
            nuevoNodo.Anterior = nuevoNodo;
            PrimerNodo = nuevoNodo;
        }
        else
        {
            NodoCircular tmp = PrimerNodo;
            while (tmp.Siguiente != PrimerNodo)
            {
                tmp = tmp.Siguiente;
            }
            tmp.Siguiente = nuevoNodo;
            nuevoNodo.Anterior = tmp;
            nuevoNodo.Siguiente = PrimerNodo;
            PrimerNodo.Anterior = nuevoNodo;
        }
    }
    
    /*
    * Agrega un nodo en una posición de la lista. Los indices de la lista empiezan en 1
    */
    public void AgregarNodoPos(String dato, int pos)
    {
        if(PrimerNodo == null || pos == 1)
        {
            AgregarNodoInicio(dato);
        }
        else
        {
            NodoCircular nuevoNodo = new NodoCircular(dato);
            NodoCircular tmp = PrimerNodo;
            for(int i = 2; i<pos; i++)
            {
                tmp = tmp.Siguiente;
            }
            nuevoNodo.Siguiente = tmp.Siguiente;
            tmp.Siguiente.Anterior = nuevoNodo;
            nuevoNodo.Anterior = tmp;
            tmp.Siguiente = nuevoNodo;
        }
    }
}

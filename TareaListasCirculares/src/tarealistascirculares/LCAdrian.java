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
        LCircular.AgregarNodo("3", true);
        LCircular.AgregarNodo("2", true);
        LCircular.AgregarNodo("1", true);
        LCircular.AgregarNodo("4", false);
        LCircular.AgregarNodoPos("12", 3);
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
     * Agrega un nodo al inicio de la lista. El parámetro 'inicio' indica si el nodo se está agregando al inicio o al final de la lista
     */
    public void AgregarNodo(String dato, boolean inicio) {
        NodoCircular tmp = new NodoCircular(dato);
        if (PrimerNodo == null) {
            tmp.Siguiente = tmp;
            tmp.Anterior = tmp;
            PrimerNodo = tmp;
        }
        else {
            tmp.Siguiente = PrimerNodo;
            PrimerNodo.Anterior.Siguiente = tmp;
            tmp.Anterior = PrimerNodo.Anterior;
            PrimerNodo.Anterior = tmp;
            if(inicio)
            {
                PrimerNodo = tmp;
            }
        }
    }

    /*
    * Agrega un nodo en una posición de la lista. Los indices de la lista empiezan en 1
    */
    public void AgregarNodoPos(String dato, int pos)
    {
        if(PrimerNodo == null || pos == 1)
        {
            AgregarNodo(dato, true);
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

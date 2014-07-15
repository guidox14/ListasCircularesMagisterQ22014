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
public class LCPaul {

    public static void main(String[] args) {
        ListaDobleEnlazada listaDobleEnlazadaPrueba = new ListaDobleEnlazada();
        listaDobleEnlazadaPrueba.AgregarNodoInicio("2");
    }

}

/*
 * No es necesario utilizar NodoDoble, para eso es NodoDobleEnlazada
 */
class NodoDobleEnlazada {

    public NodoDobleEnlazada Siguiente;
    public NodoDobleEnlazada Anterior;
    public Object Dato;

    //Constructor vacío
    public NodoDobleEnlazada() {
        Siguiente = null;
        Anterior = null;
        Dato = null;
    }

    //Constructor que define el objecto del nodo solamente
    public NodoDobleEnlazada(Object dato) {
        Dato = dato;
        Siguiente = null;
        Anterior = null;
    }

    //Constructor que define el objetodel nodo y el nodo siguiente
    public NodoDobleEnlazada(Object dato, NodoDobleEnlazada siguiente) {
        Siguiente = siguiente;
        Dato = dato;
        Anterior = null;
    }

    //Constructor que define el objeto del nodo y el nodo anterior
    public NodoDobleEnlazada(Object dato, NodoDobleEnlazada anterior, NodoDobleEnlazada siguiente) {
        Siguiente = siguiente;
        Dato = dato;
        Anterior = anterior;
    }
}

/*
 * Clase que tiene los métodos de la lista doble
 */
class ListaDobleEnlazada {

    public NodoDobleEnlazada PrimerNodo;

    //Constructor Vacío
    public ListaDobleEnlazada() {
        PrimerNodo = null;
    }

    //Imprime toda la lista
    public void ImprimirListaDobleEnlazada() {
        if (PrimerNodo == null) {
            System.out.println("La lista está vacía");
        } else {
            NodoDobleEnlazada tmp = PrimerNodo;
            while (tmp != null) {
                System.out.println(tmp.Dato);
                System.out.println(tmp.Siguiente);
                System.out.println(tmp.Anterior);
                tmp = tmp.Siguiente;
            }
        }
    }

    //Agrega un nodo al inicio de la lista
    public void AgregarNodoInicio(Object dato) {
        if (PrimerNodo != null) {
            PrimerNodo = new NodoDobleEnlazada(dato);
            PrimerNodo.Siguiente = PrimerNodo;
            PrimerNodo.Anterior = PrimerNodo;
        } else {
            NodoDobleEnlazada tmp = new NodoDobleEnlazada(dato);
            tmp.Siguiente = PrimerNodo;
            while (PrimerNodo.Siguiente != dato) { //¿Para que es este while?
                PrimerNodo.Siguiente = tmp;
            }

            PrimerNodo.Anterior = tmp;
            while (tmp.Anterior != dato) {
                tmp.Anterior = PrimerNodo;
            }

            PrimerNodo = tmp;

        }
    }

     //Elimina un nodo al inicio de la lista
    public void eliminarNodoInicio() {
        if (PrimerNodo != null) {
            PrimerNodo = PrimerNodo.Siguiente;
            while (PrimerNodo.Anterior == null) {
                PrimerNodo.Anterior = PrimerNodo;

            }
            PrimerNodo.Siguiente = PrimerNodo;
            while (PrimerNodo.Siguiente == null) {
                PrimerNodo.Siguiente = PrimerNodo;
            }
        } else {
            System.out.println("ERROR: La lista está vacía");

        }

    }

    //Agrega un nodo al final de la lista
    public void AgregarNodoFinal(Object dato) {
        if (PrimerNodo == null) {
            PrimerNodo = new NodoDobleEnlazada(dato);
            PrimerNodo.Siguiente = PrimerNodo;
            PrimerNodo.Anterior = PrimerNodo;
        } else {
            NodoDobleEnlazada tmp = PrimerNodo;
            while (tmp.Siguiente != null) {
                tmp = tmp.Siguiente;
            }
            NodoDobleEnlazada nuevoNodo = new NodoDobleEnlazada(dato);
            tmp.Siguiente = nuevoNodo;
            nuevoNodo.Anterior = tmp;

            PrimerNodo.Anterior = nuevoNodo;
            nuevoNodo.Siguiente = PrimerNodo;
        }
    }

     //Elimina un nodo al final de la lista
    public boolean eliminarNodoFinal() {
        if (PrimerNodo == null) {

            System.out.println("ERROR. La lista se encuentra vacia");
            return false;

        } else {

            NodoDobleEnlazada tmp = PrimerNodo;
            while (tmp.Siguiente != null) {
                tmp = tmp.Siguiente;
            }
            NodoDobleEnlazada nuevoNodoFinal = tmp.Anterior;
            nuevoNodoFinal.Siguiente = nuevoNodoFinal;
            nuevoNodoFinal.Anterior = nuevoNodoFinal;
            return true;
        }
    }
}

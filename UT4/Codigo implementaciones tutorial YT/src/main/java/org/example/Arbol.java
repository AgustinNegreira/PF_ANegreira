package org.example;

public class Arbol {
    NodoArbol inicial;

    public Arbol () {
        inicial = null;
    }

    public void insertar(int valor){
        if (inicial == null){
            inicial = new NodoArbol(valor);
        }
        else {
            inicial.insertar(valor);
        }
    }

    public void dispararPreorden(){
        preOrden(inicial);
    }

    public void preOrden (NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        else {
            System.out.print(nodo.getValor()+" ");
            preOrden(nodo.getNodoIzq());
            preOrden(nodo.getNodoDer());
        }
    }

    public void dispararInorden(){
        inOrden(inicial);
    }

    public void inOrden (NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        else {
            inOrden(nodo.getNodoIzq());
            System.out.print(nodo.getValor()+" ");
            inOrden(nodo.getNodoDer());
        }
    }

    public void dispararPosorden(){
        posOrden(inicial);
    }

    public void posOrden (NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        else {
            posOrden(nodo.getNodoIzq());
            posOrden(nodo.getNodoDer());
            System.out.print(nodo.getValor()+" ");
        }
    }
}

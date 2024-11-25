package org.example;

public class NodoArbol {
    private int valor;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;

    public NodoArbol(int valor) {
        this.valor = valor;
        nodoIzq = null;
        nodoDer = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    public void insertar(int valor) {
        if(valor < this.valor) {
            if(nodoIzq == null) {
                nodoIzq = new NodoArbol(valor);
            }
            else {
                nodoIzq.insertar(valor);
            }
        }
        else {
            if(nodoDer == null) {
                nodoDer = new NodoArbol(valor);
            }
            else {
                nodoDer.insertar(valor);
            }
        }
    }
}
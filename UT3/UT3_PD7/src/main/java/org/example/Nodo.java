package org.example;

public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    public Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    
    @Override
    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    public boolean equals(Nodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        int r;
        r = this.etiqueta.compareTo(etiqueta);
        return r;
    }
    
}
package org.example;


public class Nodo<T> implements INodo<T>{
    Comparable etiqueta;
    T valor;
    Nodo<T> siguiente;
    public Nodo(T valor, Comparable etiqueta){
        this.valor = valor;
        this.etiqueta = etiqueta;
    }
    @Override
    public T getDato() {
        return valor;
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
    public void imprimir() {
        System.out.println("Este nodo '" + this.etiqueta.toString() + "', tiene por valor "
                +this.valor.toString() + " y su siguente nodo es " + this.siguiente.etiqueta);
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public int compareTo(Comparable etiquetas) {
        return 0;
    }
    
}

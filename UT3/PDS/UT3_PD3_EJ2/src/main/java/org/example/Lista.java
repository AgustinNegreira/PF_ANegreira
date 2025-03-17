package org.example;

public class Lista<T> implements ILista<T>{

    Nodo cabeza;
    
    public Lista(){
        this.cabeza = null;
    }
    
    @Override
    public void insertar(Nodo<T> nodo) {
        if (cabeza == null){
            cabeza = nodo;
        } else {
            Nodo temp = cabeza;
            nodo.setSiguiente(temp);
            cabeza = nodo;            
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo n = cabeza;
        while (n != null){
            if (n.etiqueta != clave){
                n = n.siguiente;
            } else {
                return n;
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        Nodo temp = null;
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.etiqueta == clave){
                if (actual == cabeza){
                    actual = actual.siguiente;
                } else {
                    temp.siguiente = actual.siguiente;
                }
            }
            temp = actual;
            actual = actual.siguiente;
            
        }
        
        return false;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null){
            sb.append(actual.etiqueta + " --> ");
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esVacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setPrimero(Nodo unNodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

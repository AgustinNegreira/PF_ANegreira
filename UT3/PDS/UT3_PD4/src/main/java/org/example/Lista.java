package org.example;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;
    int cont;

    public Lista() {
        primero = null;
    }


    // implementar los metodos indicados en la interfaz

    @Override
    public void insertar(Nodo<T> nodo) {
        if (primero == null){
            primero = nodo;
            cont++;
        } else {
            Nodo temp = primero;
            nodo.setSiguiente(temp);
            primero = nodo;        
            cont++;
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo n = primero;
        while (n != null){
            if (n.compareTo(clave) != 0){
                n = n.getSiguiente();
            } else {
                return n;
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        Nodo temp = null;
        Nodo actual = primero;
        
        while (actual != null){
            if (actual.compareTo(clave) == 0){
                if (actual == primero){
                    actual = actual.getSiguiente();
                    cont--;
                    System.out.println("Se elimino " + clave + " de la lista.");
                    return true;
                } else {
                    temp.setSiguiente(actual.getSiguiente());
                    cont--;
                    System.out.println("Se elimino " + clave + " de la lista.");
                    return true;
                }
            }
            temp = actual;
            actual = actual.getSiguiente();
            
        }
        if (primero == null){
            System.out.println("La lista está vacia, no se puede eliminar "
                    + clave + ". Ya que no existen elementos.");
        }
        System.out.println("El elemento '" + clave + "' no estaba en la lista.");
        return false;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = primero;
        while (actual != null){
            sb.append(actual.getEtiqueta() + " --> ");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        Nodo actual = primero;
        while (actual != null){
            sb.append(actual.getEtiqueta());
            sb.append(separador);
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        return cont;
    }

    @Override
    public boolean esVacia() {
        if (cont == 0){
            return true;
        }
        return false;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = this.primero.siguiente;
    }
    
    public Nodo<T> getNodo(){
        return this.primero;
    }
}

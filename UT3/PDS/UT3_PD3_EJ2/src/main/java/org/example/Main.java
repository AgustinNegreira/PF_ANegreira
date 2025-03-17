package org.example;

public class Main {
    public static void main(String[] args) {

        Nodo n1 = new Nodo("a",1);
        Nodo n2 = new Nodo("b",2);
        Nodo n3 = new Nodo("c",3);
        Nodo n4 = new Nodo("d",4);
        Lista list = new Lista();
        list.insertar(n1);
        list.insertar(n2);
        list.insertar(n3);
        list.insertar(n4);

        System.out.println(list.imprimir());
        list.eliminar(2);
        System.out.println(list.imprimir());

        System.out.println(n4.valor);
        n2.imprimir();
    }
}
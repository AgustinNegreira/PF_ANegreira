package org.example;

public class Main {
    public static void main(String[] args) {
        Almacen a1 = new Almacen("chapita","094158074", "almacen1");
        System.out.println(a1.getListaProductos().imprimir());
        System.out.println(a1.getListaProductos().imprimir());
        Comparable ax = "1000198";
        System.out.println(a1.buscarPorCodigo(ax));

    }
}
package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar(43);
        arbol.insertar(20);
        arbol.insertar(25);
        arbol.insertar(2);
        arbol.insertar(13);

        System.out.println("PreOrden:");
        arbol.dispararPreorden();
        System.out.println("\n");

        System.out.println("InOrden:");
        arbol.dispararInorden();
        System.out.println("\n");

        System.out.println("PosOrden:");
        arbol.dispararPosorden();
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        String[] elemA = {"2","3","5","7"};
        String[] elemB = {"1","3","4","8"};
        Conjunto conjA = new Conjunto("conjA", elemA );
        Conjunto conjB = new Conjunto("conjB", elemB );

        conjA.insertConj2List();
        conjB.insertConj2List();
        /*Conjunto union = Conjunto.unionConj(conjA, conjB);
        union.listaSucursales.imprimir();*/
        Conjunto unionAB = conjA.union(conjB);
        System.out.println("Union: " + unionAB.conjuntos.imprimir());

        Conjunto interAB = conjA.interseccion(conjB);
        System.out.println("Insertección: " + interAB.conjuntos.imprimir());
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        // PD0 ejercicio 1
        ArbolBB arbol = new ArbolBB();
        ElementoAB ocho = new ElementoAB(8,8);
        ElementoAB dos = new ElementoAB(2,2);
        ElementoAB tres = new ElementoAB(3,3);
        ElementoAB cuatro = new ElementoAB(4,4);
        ElementoAB suma = new ElementoAB("+","+");
        ElementoAB resta = new ElementoAB("-","-");
        ElementoAB mult = new ElementoAB("*","*");

        arbol.insertar(mult);
        mult.setHijoDer(cuatro);
        mult.setHijoIzq(resta);
        resta.setHijoDer(tres);
        resta.setHijoIzq(suma);
        suma.setHijoDer(dos);
        suma.setHijoIzq(ocho);
        System.out.println("Obtener la arbol InOrder: ((8+2)-3)*4 \n"+ arbol.inOrden());
        System.out.println();
        System.out.println("Obtener valor de la expresion expresión: \n"+ arbol.calcularOperaciones());
        System.out.println();
        // PD0 Ejercicio2
        ArbolBB ABBexp = new ArbolBB();
        ABBexp.insertarExpresion("((1+2)*3)+6/(8-4)");
        System.out.println("Obtener la expresion InOrder: \n" + ABBexp.getRaiz().inOrden());
    }
}
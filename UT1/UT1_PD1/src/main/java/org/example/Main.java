package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Multsuma.multsuma(1.0, 2.0, 3.0));
        
        //

        Contador contador1 = new Contador();
        Contador contador2 = new Contador();
        Contador contador3 = new Contador();
        contador1.mostrarContador();
        contador2.mostrarContadorDW();
        contador3.mostrarContadorF();
    }
}
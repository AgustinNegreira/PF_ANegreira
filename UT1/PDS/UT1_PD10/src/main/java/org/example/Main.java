package org.example;

public class Main {
    public static void main(String[] args) {
        String[] Ar1={"Hola", "mundo", "de", "los", "algoritmos"};
        String[] Ar2={"Hola", "mundo", "de", "la", "informática"};
        String[] arResultante = ContadorPalabras.palabrasComunes(Ar1, Ar2);
        for (String palabra : arResultante)
            System.out.println(palabra);
    }
}
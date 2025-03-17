package org.example;

// Ejercicio 5
public class Contador {
    final int MAX_CONT = 50;
    int incremento = 1;
    int contador = 1;

    public void mostrarContador(){
        while (contador <= MAX_CONT){
            System.out.println(contador);
            contador+=incremento;
        }
    }

    public void mostrarContadorDW(){
        do {
            System.out.println(contador);
            contador+=incremento;
        }
        while (contador <= MAX_CONT);
    }

    public void mostrarContadorF(){
        for (; contador <= MAX_CONT; contador += incremento){
            System.out.println(contador);
        }
    }
}

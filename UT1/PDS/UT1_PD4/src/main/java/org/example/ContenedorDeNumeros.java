package org.example;
// Ejercicio 3 parte 3)
public class ContenedorDeNumeros {
    public int anInt;
    public float aFloat;

    public static void main(String[] args){
        ContenedorDeNumeros contenedor = new ContenedorDeNumeros();
        contenedor.anInt = 8;
        contenedor.aFloat = 3.14f;
        System.out.println("contenedor.anInt = " + contenedor.anInt);
        System.out.println("contenedor.aFloat = " + contenedor.aFloat);
    }
}

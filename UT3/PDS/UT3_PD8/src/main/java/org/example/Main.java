package org.example;

public class Main {
    public static void main(String[] args) {
        Sucursales suc = new Sucursales();
        String dir = "D:\\UCU 4to semestre\\AED\\UT3\\UT3_PD8\\src\\main\\java\\org\\example\\suc1.txt";
        suc.insertArrayList(dir);
        System.out.println("\n======== Imprimir ==========");
        System.out.println(suc.imprimir());
        System.out.println("\n========= Agregar ==========");
        suc.agregarSuc("San Carlos");
        System.out.println("\n======== Buscar ============");
        System.out.println(suc.buscar("San Carlos"));
        System.out.println("\n========= Eliminar =========");
        suc.eliminar("San Carlos");
        System.out.println("\n======== Contar ============");
        suc.cantidadSucursales();
        System.out.println("\n========= Es vacio =========");
        System.out.println(suc.esVacio());
        System.out.println("\n========= Eliminar =========");
        suc.eliminar("San Carlos");
        System.out.println("\n====================================");
        System.out.println("========= Ejercicio parte5 =========\n");
        // EJERCICIO 5
        Sucursales suc1 = new Sucursales();
        String dir1 = "D:\\UCU 4to semestre\\AED\\UT3\\UT3_PD8\\src\\main\\java\\org\\example\\suc1.txt";
        suc1.insertArrayList(dir1);
        System.out.println("\n========= Parte 1 =========");
        System.out.println("La cantidad de sucursales son:");
        suc1.cantidadSucursales();
        System.out.println("Respuesta D.");

        System.out.println("\n========= parte 2 =========");
        suc1.eliminar("Chicago");
        int indice = suc.sucursales.indexOf("Hong Kong");
        System.out.println(suc1.sucursales.get(indice +1));
        System.out.println("Respuesta C.");

        System.out.println("\n========= parte 3 =========");
        Sucursales suc2 = new Sucursales();
        String dir2 = "D:\\UCU 4to semestre\\AED\\UT3\\UT3_PD8\\src\\main\\java\\org\\example\\suc2.txt";
        suc2.insertArrayList(dir2);
        suc2.eliminar("Shenzhen");
        suc2.eliminar("﻿Tokio");
        System.out.println("Respuesta D.");

        System.out.println("\n========= parte 4 =========");
        Sucursales suc3 = new Sucursales();
        String dir3 = "D:\\UCU 4to semestre\\AED\\UT3\\UT3_PD8\\src\\main\\java\\org\\example\\suc3.txt";
        suc3.insertArrayList(dir3);
        System.out.println(suc3.imprimir(";_"));
        System.out.println("Respuesta C.");

    }
}
package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Se corre con argumentos desde la terminal

        args[0] = "org/example/randomEntrada.txt";
        HashMap<String, String> texto = new HashMap<>();
        texto.put("testt", "dadaw");
        texto.put("k1", "v1");
        texto.put("ag" , null);
        texto.put("ae", null);
        texto.put("k2", "v2");
        texto.put("k3", "v3");
        texto.put("k4", "v4");

        // Ejercicio 1, eliminar Entradas con valores nulos.
        // Uso de ArrayList y sentencias for
        System.out.println("### EJERCICIO 1 ###");
        texto = ManejoMaps.quitaValorNulo(texto);
        for (Map.Entry<String, String> entry : texto.entrySet()) {
            System.out.println("clave= " + entry.getKey() + ", valor= " + entry.getValue());
        }

        // Ejercicio 2, invierte valores y claves
        System.out.println("\n### EJERCICIO 2 ###");
        texto = ManejoMaps.invierteMap(texto);
        for (Map.Entry<String, String> entry : texto.entrySet()) {
            System.out.println("clave= " + entry.getKey() + ", valor= " + entry.getValue());
        }

        // Ejercicio 3, ordenar entradas por tamaño
        System.out.println("\n### EJERCICIO 3 ###");
        HashMap<String, String> mapOrdenado = ManejoMaps.ordenTamEntrada("org/example/entradas.txt");

        // Ejercicio 4, leer lineas argumento
        System.out.println("\n### EJERCICIO 4 ###");
        String argumento = args[0];
        ManejoMaps.randomLectura(argumento, 2);
    }
}
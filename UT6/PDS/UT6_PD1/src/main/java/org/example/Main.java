package org.example;

public class Main {
    public static void main(String[] args) {

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/main/java/jumpert/ut6_pd1/prueba.txt");

        for (String p : palabrasclave) {
            System.out.println(p);
        }

        //System.out.println(trie.predecir("bo"));
    }
}
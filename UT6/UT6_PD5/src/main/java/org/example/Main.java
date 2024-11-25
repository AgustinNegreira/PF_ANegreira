package org.example;

public class Main {
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT6\\UT6_PD5\\src\\main\\java\\org\\example\\palabras1.txt");
        for (String p : palabrasclave) {
            trie.insertar(p);
        }
        trie.imprimir();
        System.out.println(trie.predecir("bo"));
    }
}
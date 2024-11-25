package org.example;

public class Main {
    public static void main(String[] args) {
        String[] libro = ManejadorArchivosGenerico.leerArchivo("./src/main/java/jumpert/ut5_pd3/Libro.txt");
        /*TArbolTrie trie = new TArbolTrie();
        for (int i = 0; i < libro.length; i++){
            trie.indizarLibro(libro[i], i);
        }
        trie.imprimir();*/

        for (int i = 0; i < libro.length; i++){
            TNodoTrie.printwords(libro[i]);
        }
    }
}
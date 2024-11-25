package org.example;

public class Main {
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT5\\UT5_PD2\\UT5_PD2\\src\\main\\java\\org\\example\\palabras1.txt");
        for (String p : palabrasclave) {
            //System.out.println(p);
            trie.insertarTextoPorLinea(p);
        }
        trie.imprimir();

        System.out.println("");
        System.out.println("Buscar paginas ");
        System.out.println(trie.buscar("ala"));

        /*
        TArbolTrie trie1 = new TArbolTrie();
        String[] palabrasclave1 = ManejadorArchivosGenerico.leerArchivo("D:\UCU 4to semestre\AED\portafolio-AgustinNegreira\UT5\UT5_PD2\UT5_PD2\src\main\java\org\example\palabras2.txt");
        for (String p : palabrasclave1) {
            //System.out.println(p);
                trie1.insertarPatricia(p);
        }
        trie1.imprimir();
        System.out.println(trie.buscar("ala"));
        */
    }
}
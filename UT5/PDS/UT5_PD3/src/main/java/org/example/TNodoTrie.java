package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private ArrayList<Integer> paginas;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }
    
      private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
    
    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s+(char)(c + 'a'),palabras, nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        //predecir(prefijo, palabras, buscarNodoTrie(prefijo));
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        if (nodo != null){
            predecir(prefijo, palabras, nodo);
        }
    }

    @Override
    public int buscar(String palabra) {
        TNodoTrie nodo = this;
        System.out.print(palabra + ": ");
        for (int c = 0; c < palabra.length(); c++) {
            int indice = palabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return 0;
            }
            nodo = nodo.hijos[indice];
        }
        for (int i = 0; i < nodo.paginas.size(); i++) {
            System.out.print(nodo.paginas.get(i) + " ");
        }
        System.out.println("");
        return nodo.paginas.get(0);
    }
            
    public ArrayList<Integer> obtenerPag(String texto) {
        String[] str = texto.split(", ");
        ArrayList<Integer> pag = new ArrayList(); 
        for (String str1 : str) {
            pag.add(Integer.parseInt(str1));
        }
        return pag;
    }
            
    public void insertarTextoPorLinea(String texto, int linea){
               
        TNodoTrie nodo = this;
        for (int c = 0; c < texto.length(); c++) {
            int indice = texto.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        //nodo.paginas.add(obtenerPag(texto.substring(i + 2)));
        nodo.esPalabra = true;
    }
    private void insertLibro(String palabra, int valor){
         TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            int indice = palabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.paginas != null){
            nodo.paginas.add(valor);
        } else {
            nodo.paginas = new ArrayList(1);
            nodo.paginas.add(valor);
        }
        nodo.esPalabra = true;
    }
    public void indizarLibro(String texto, int valor){
        texto = texto.trim();
        String delims = "\\W+";
        String[] palabras = texto.split(delims);
        for (String palabra : palabras){
            if (palabra.compareTo("\n") != 0 || palabra.compareTo(" ") != 0){
                insertLibro(palabra.toLowerCase(), valor);
            }
        }
    }
    
    static void printwords(String str)
    {
        // eliminate leading and trailing spaces
        str = str.trim().toLowerCase();
            str = str.replaceAll("(\n|\r)", "");
        if (str != null){
            // split all non-alphabetic characters
            String delims = "\\W+"; // split any non word
            String[] tokens = str.split(delims);

            // print the tokens
            for (String item : tokens) {

                System.out.println(item + " ");
            }
        }
    }
}
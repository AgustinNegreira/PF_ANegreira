package org.example;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private int[] paginas;
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
        for (int i = 0; i < nodo.paginas.length; i++) {
            System.out.print(nodo.paginas[i] + " ");
        }
        System.out.println("");
        return nodo.paginas[0];
    }
            
            public int[] obtenerPag(String texto) {
                String[] str = texto.split(", ");
                int [] pag = new int [str.length]; 
                for (int i = 0; i < str.length;i++){
                    pag[i] = Integer.parseInt(str[i]);
                }
                return pag;
            }
            
    
    public void insertarTextoPorLinea(String texto){
        int i = 0;
        while (texto.charAt(i) != ','){
            i++;
        }
        String palabra = texto.substring(0,i);
        
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            int indice = palabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.paginas = obtenerPag(texto.substring(i + 2));
        nodo.esPalabra = true;
    }
    private void insertPatricia(String palabra, int valor){
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            int indice = palabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        
        nodo.paginas = new int[valor];
        nodo.esPalabra = true;
    }
    public void insertarPatricia(String texto){
        int i = 1;
        int j = 1;
        while (i <= texto.length()){
            
            if (texto.charAt(i) == ' ' ){
                String palabra = texto.substring(j, i);
                insertPatricia(palabra, j);
                j = i;
            } else if(texto.charAt(i) == '.' || texto.charAt(i) == ',' ){
                String palabra = texto.substring(j, i);
                insertPatricia(palabra, j);
                
                j = i;
            }
            i++;
        }
    }
}
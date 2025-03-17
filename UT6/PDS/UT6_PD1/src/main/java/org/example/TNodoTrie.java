package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private  HashMap <String, TNodoTrie> hashContenedorNodos = new HashMap <String, TNodoTrie> ();
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
                nodo.hashContenedorNodos.put(unaPalabra, nodo);
            }
            nodo = nodo.hijos[indice];         
        }
        nodo.esPalabra = true;
    }

    @Override
    public void imprimir() {
      for (Map.Entry<String, TNodoTrie> entry : hashContenedorNodos.entrySet()) {
            String palabra = entry.getKey();
         
             System.out.println(palabra);
        }
    }
    
    public TNodoTrie buscarNodoTrie(String s) {
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
        predecir(prefijo, palabras, buscarNodoTrie(prefijo));
    }
    public boolean buscarEnHashMap(String palabra){
        for (Map.Entry<String, TNodoTrie> entry : hashContenedorNodos.entrySet()) {
            String key = entry.getKey();
            
            if(key.contains(palabra)){
                return true;
            }
    }
    return false;
    }
    
    @Override
    public int buscar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
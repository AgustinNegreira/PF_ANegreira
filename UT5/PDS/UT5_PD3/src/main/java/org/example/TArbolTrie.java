package org.example;

import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz != null){
            return raiz.buscar(palabra);
        } else {
            return 0;
        }
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> lista = new LinkedList();
        if (prefijo == null || raiz == null){
            return lista;
        }else{
            raiz.predecir(prefijo, lista);
        }
        return lista;
    }
    
    public void indizarLibro(String texto, int linea){
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.indizarLibro(texto, linea);
    }
}
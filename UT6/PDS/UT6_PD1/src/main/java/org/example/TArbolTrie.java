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
    public LinkedList<String> predecir(String prefijo) { //PRECONDICION: TODOS LOS CARACTERES DEL PREFIJO PERTENECEN AL ABECEDARIO
        prefijo = prefijo.toLowerCase();
        LinkedList lista = new LinkedList();
        if (raiz == null)
            return lista;
        else
            raiz.predecir(prefijo, lista);
        return lista;
    }

    @Override
    public int buscar(String palabra) {
    if (raiz == null)
            return 0;
    else
       return raiz.buscar(palabra);
    }
    public boolean buscarEnHash(String palabra){
        if (raiz != null) {
            return raiz.buscarEnHashMap(palabra);
      }else{
            return false;
        }
    }
}
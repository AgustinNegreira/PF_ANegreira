package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;
import java.util.List;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(Comparable etiqueta, T unDato) {
        IElementoAB<T> nuevoElemento = new TElementoAB<>(etiqueta, unDato);
        if (raiz == null) {
            raiz = nuevoElemento;
            return true;
        } else {
            return raiz.insertar(nuevoElemento);
        }
    }

    @Override
    public T buscar(Comparable unaEtiqueta) {
        if (raiz != null) {
            IElementoAB<T> encontrado = raiz.buscar(unaEtiqueta);
            if (encontrado != null) {
                return encontrado.getDatos();
            }
        }
        return null;
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        raiz = eliminarRecursivo(raiz, unaEtiqueta);
    }

    private IElementoAB<T> eliminarRecursivo(IElementoAB<T> nodo, Comparable unaEtiqueta) {
        if (nodo == null) {
            return null;
        }

        if (unaEtiqueta.compareTo(nodo.getEtiqueta()) < 0) {
            nodo.setHijoIzq(eliminarRecursivo(nodo.getHijoIzq(), unaEtiqueta));
        } else if (unaEtiqueta.compareTo(nodo.getEtiqueta()) > 0) {
            nodo.setHijoDer(eliminarRecursivo(nodo.getHijoDer(), unaEtiqueta));
        } else {
            // Caso 1: Sin hijos o un hijo
            if (nodo.getHijoIzq() == null) {
                return nodo.getHijoDer();
            } else if (nodo.getHijoDer() == null) {
                return nodo.getHijoIzq();
            }

            // Caso 2: Dos hijos
            IElementoAB<T> sucesor = buscarSucesor(nodo.getHijoDer());
            nodo.setEtiqueta(sucesor.getEtiqueta());
            nodo.setDatos(sucesor.getDatos());
            nodo.setHijoDer(eliminarRecursivo(nodo.getHijoDer(), sucesor.getEtiqueta()));
        }

        return nodo;
    }

    private IElementoAB<T> buscarSucesor(IElementoAB<T> nodo) {
        IElementoAB<T> actual = nodo;
        while (actual.getHijoIzq() != null) {
            actual = actual.getHijoIzq();
        }
        return actual;
    }

    @Override
    public List<T> preOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (raiz != null) {
            raiz.preOrden(lista);
        }
        return lista;
    }

    @Override
    public List<T> inOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (raiz != null) {
            raiz.inOrden(lista);
        }
        return lista;
    }

    @Override
    public List<T> postOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (raiz != null) {
            raiz.postOrden(lista);
        }
        return lista;
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    @Override
    public boolean vaciar() {
        raiz = null;
        return true;
    }
}

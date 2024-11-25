package uy.edu.ucu.aed.tdas;
import java.util.LinkedList;


public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB<T> hijoIzq;
    private IElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return 
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta){
        this.etiqueta = etiqueta;
    }

    public void setDatos(T datos){
        this.datos = datos;
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public IElementoAB<T> getHijoIzq(){
        return this.hijoIzq;
    }

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public IElementoAB<T> getHijoDer(){
        return this.hijoDer;
    }

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(IElementoAB<T> elemento){
        this.hijoIzq = elemento;
    }

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(IElementoAB<T> elemento){
        this.hijoDer = elemento;
    }

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta){
        if (unaEtiqueta.equals(this.etiqueta)){
            return this;
        }
        else if (unaEtiqueta.compareTo(this.etiqueta) < 0 ){
            this.hijoIzq.buscar(unaEtiqueta);
        }
        else{
            this.hijoDer.buscar(unaEtiqueta);
        }
        return null;
    }


    public boolean insertar(IElementoAB<T> elemento){
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0 ){
            if (this.hijoIzq == null){
                this.hijoIzq = elemento;
            }
            else{
                this.hijoIzq.insertar(elemento);
                return true;
            }
        }
        else{
            if (this.hijoDer == null){
                this.hijoDer = elemento;
            }
            else{
                this.hijoDer.insertar(elemento);
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega las etiquetas del recorrido en preorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void preOrden(LinkedList<T> unaLista) {
        if (this != null) {
            unaLista.add((T) this.getEtiqueta());  // Agrega la etiqueta del nodo actual
            if (this.getHijoIzq() != null) {
                this.getHijoIzq().preOrden(unaLista);  // Recorre el hijo izquierdo
            }
            if (this.getHijoDer() != null) {
                this.getHijoDer().preOrden(unaLista);  // Recorre el hijo derecho
            }
        }
    }

    /**
     * Agrega las etiquetas del recorrido en inorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void inOrden(LinkedList<T> unaLista) {
        if (this != null) {
            if (this.getHijoIzq() != null) {
                this.getHijoIzq().inOrden(unaLista);  // Recorre el hijo izquierdo
            }
            unaLista.add((T) this.getEtiqueta());  // Agrega la etiqueta del nodo actual
            if (this.getHijoDer() != null) {
                this.getHijoDer().inOrden(unaLista);  // Recorre el hijo derecho
            }
        }
    }

    /**
     * Agrega las etiquetas del recorrido en postorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void postOrden(LinkedList<T> unaLista) {
        if (this != null) {
            if (this.getHijoIzq() != null) {
                this.getHijoIzq().postOrden(unaLista);  // Recorre el hijo izquierdo
            }
            if (this.getHijoDer() != null) {
                this.getHijoDer().postOrden(unaLista);  // Recorre el hijo derecho
            }
            unaLista.add((T) this.getEtiqueta());  // Agrega la etiqueta del nodo actual.
        }
    }


    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos(){
        return this.datos;
    }


    /**
     * Elimina un elemento dado una etiqueta.
     *
     * @param unaEtiqueta Etiqueta del elemento a eliminar.
     * @return Elemento que fue eliminado. Si no se encuentra, retorna nulo.
     */
    /*
    public IElementoAB<T> eliminar(Comparable unaEtiqueta){
        TElementoAB<T> elementoEncontrado = buscar(unaEtiqueta);
        if (elementoEncontrado != null){

        }
    }

    public IElementoAB<T>  quitarNodo(Comparable unaEtiqueta){
        if (this.hijoIzq == null && this.hijoDer == null){
            return unaEtiqueta;
        }
        else if (this.hijoDer != null){

        }
    }
    */

    /**
     * Obtiene el tamaño del árbol (número de elementos).
     *
     * @return Tamaño del árbol.
     */
    /*
    public int obtenerTamaño(){

    }
     */
}

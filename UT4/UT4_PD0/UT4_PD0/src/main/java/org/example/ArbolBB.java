package org.example;

public class ArbolBB implements IArbolBB<Object>{

    private ElementoAB raiz = null;
    
    
    @Override
    public boolean insertar(ElementoAB<Object> unElemento) {
        if (this.esVacio()){
            this.raiz = unElemento;
            return true;
        } else {
            return this.raiz.insertar(unElemento);
        }
    }

    @Override
    public ElementoAB<Object> buscar(Comparable unaEtiqueta) {
        if (!this.esVacio()) {
            return this.raiz.buscar(unaEtiqueta);        
        }           
        return null;
    }

    public String getERaiz(){
        return raiz.getEtiqueta().toString();
    }
    public ElementoAB getRaiz(){
        return raiz;
    }
    
    @Override
    public String preOrden() {
        if (!this.esVacio()) {
            return this.raiz.preOrden();
        }
        return "Arbol Vacio";
    }

    @Override
    public String inOrden() {
        if (!this.esVacio()) {
            return this.raiz.inOrden();          
        }
        return "Arbol Vacio";
    }

    @Override
    public String postOrden() {
        if (!this.esVacio()) {
            return this.raiz.postOrden();    
        }
        return "Arbol Vacio";
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null){
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }
    
    public boolean esVacio() {
        return this.raiz == null;
    }
    
    
    public int calcularOperaciones(){
        ArbolBB arbol = new ArbolBB();
        arbol = this;
        if (raiz != null){
            return arbol.raiz.calcularOperaciones();
        }
        return 0;
    }
    
    public boolean insertarExpresion(String expresion){
        raiz = new ElementoAB(0, 0);
        if (raiz.getEtiqueta().compareTo(0) == 0){
            raiz = new ElementoAB(expresion,expresion);
            return true;
        }else{
            System.out.println("a");
            return this.raiz.insertarExpresion(expresion);
        }
    }
}

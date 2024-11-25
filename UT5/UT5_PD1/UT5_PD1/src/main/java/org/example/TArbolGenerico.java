package org.example;

public class TArbolGenerico implements ITArbolGenerico{

    private TNodoGenerico raiz = new TNodoGenerico("", "");
    
    
    public boolean insertar(Comparable unidadEtiqueta, Comparable etiquetaPadre){
        
        if (raiz.getEtiqueta().equals("")){
            raiz = new TNodoGenerico(unidadEtiqueta,etiquetaPadre);
            return true;
        }else {
            return raiz.insertar(unidadEtiqueta, etiquetaPadre);
        }
    }
    
    public TNodoGenerico buscar(Comparable unaEtiqueta) {
        
        if (raiz.getEtiqueta().equals(unaEtiqueta)){
            return raiz;
        }else{
            return raiz.buscar(unaEtiqueta);
        }
    }
    
    public boolean esVacio() {
        return this.raiz == null;
    }
    
    public String listarIndentado(){
        if (raiz == null){
            return "nulo";
        } else {
            return raiz.listarIndentado(0);
        }
    }
    
    public TNodoGenerico getRaiz(){
        return raiz;
    }
}
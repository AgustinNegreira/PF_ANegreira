package org.example;

interface ITArbolGenerico {
    public boolean insertar(Comparable unidadEtiqueta, Comparable etiquetaPadre);
    
    public TNodoGenerico buscar(Comparable unaEtiqueta);
    
    public boolean esVacio();
    
    public String listarIndentado();
     
    public TNodoGenerico getRaiz();
}
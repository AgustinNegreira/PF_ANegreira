package org.example;

interface ITNodoGenerico {
    public Comparable getEtiqueta();
    
    public TNodoGenerico buscar(Comparable unaEtiqueta);
    
    public boolean insertar(Comparable unidadEtiqueta, Comparable etiquetaPadre);
    
    public String listarIndentado(int valor);
}

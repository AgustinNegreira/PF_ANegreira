package org.example;

import java.util.ArrayList;

public class TNodoGenerico implements ITNodoGenerico {

    private final Comparable etiqueta;
    public Comparable padre;
    public TNodoGenerico siguienteHermano;
    public ArrayList sigHermano;
    public TNodoGenerico primerHijo;

    public TNodoGenerico(Comparable unidadEtiqueta, Comparable unPadre) {
        this.etiqueta = unidadEtiqueta;
        this.padre = unPadre;
        this.sigHermano = new ArrayList(1);
    }
    
    public Comparable getEtiqueta(){
        return this.etiqueta;
    }
    
    public TNodoGenerico buscar(Comparable unaEtiqueta){
        
        if (unaEtiqueta.compareTo(etiqueta) == 0){
            return this;
        } else {
           if (primerHijo != null){
               while (primerHijo.siguienteHermano != null){
                   return primerHijo.siguienteHermano.buscar(unaEtiqueta);
               }
               return primerHijo.buscar(unaEtiqueta);
           }
           if (siguienteHermano != null){
               return siguienteHermano.buscar(unaEtiqueta);
           }
        }
        return null;
    }
    
    public boolean insertar(Comparable unidadEtiqueta, Comparable etiquetaPadre) {
        if (unidadEtiqueta.compareTo(this.etiqueta) == 0){
            return false;
        }
        if (etiquetaPadre.compareTo(this.etiqueta) == 0){
            if (this.primerHijo != null){
                if (this.primerHijo.siguienteHermano != null){
                    this.primerHijo.siguienteHermano.insertar(unidadEtiqueta, etiquetaPadre);
                } else {
                    this.primerHijo.siguienteHermano = new TNodoGenerico(unidadEtiqueta, etiquetaPadre);
                    this.primerHijo.sigHermano.add(unidadEtiqueta);
                    return true;
                }
            }else{
                this.primerHijo = new TNodoGenerico(unidadEtiqueta, etiquetaPadre);
                return true;
            }
            return false;
        } else {
            if (this.primerHijo != null){
                this.primerHijo.insertar(unidadEtiqueta, etiquetaPadre);
            } else {
                if (this.siguienteHermano != null){
                    this.siguienteHermano.insertar(unidadEtiqueta, etiquetaPadre);
                } else {
                    if (this.primerHijo == null){

                        this.siguienteHermano = new TNodoGenerico(unidadEtiqueta, etiquetaPadre);
                        this.sigHermano.add(unidadEtiqueta);
                        return true;
                    }
                }
                
            }
            return false;
        }
    }

    
    public String listarIndentado(int valor){
        StringBuilder texto = new StringBuilder("");
        texto.append("\t".repeat(valor));
        texto.append((this.etiqueta) + "\n");
        TNodoGenerico hijo = primerHijo;
        
        if (hijo != null){
            texto.append(hijo.listarIndentado(valor + 1));
            TNodoGenerico hermano = hijo.siguienteHermano;
            while (hermano != null){
                texto.append(hermano.listarIndentado(valor + 1));
                hermano = hermano.siguienteHermano;
            }
        }
        return texto.toString();
    }
}    
package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // UT8_PD4 PARTE1
        TGrafoNoDirigido grafoND = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD4\\UT8_PD4\\src\\main\\java\\org\\example\\CC.txt","D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD4\\UT8_PD4\\src\\main\\java\\org\\example\\UcuRedes.txt",
                false, TGrafoNoDirigido.class);
        System.out.println("UT8 PD4");
        System.out.println("Ejercicio 1");
        TGrafoNoDirigido grafoUcuRedes = grafoND.Kruskal();
        System.out.println("Costo total: " + grafoUcuRedes.getCostoTotal());
        for(TArista arista : grafoUcuRedes.UcuRedes()){
            System.out.println("Origen: " + arista.getEtiquetaOrigen() + "\tDestino: " +
                    arista.getEtiquetaDestino() + "\tCosto: "+ arista.getCosto());
        }

        // UT8_PD4 PARTE2
        System.out.println("");
        System.out.println("Parte 2");
        Collection verticesUcu = grafoUcuRedes.getVertices().values();
        Iterator<TVertice> iterator = verticesUcu.iterator();
        ArrayList<TVertice> vert = new ArrayList(verticesUcu.size());
        // while loop
        while (iterator.hasNext()) {
            System.out.println("valores: " + iterator.next().getEtiqueta());
            vert.add(iterator.next());
        }
        System.out.println(grafoUcuRedes.conectados((TVertice) vert.get(0), (TVertice) vert.get(4)));
    }
}
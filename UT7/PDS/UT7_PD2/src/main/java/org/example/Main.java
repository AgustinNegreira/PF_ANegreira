package org.example;

public class Main {
    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT7\\UT7_PD2\\src\\main\\java\\org\\example\\PD2vertices.txt", "D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT7\\UT7_PD2\\src\\main\\java\\org\\example\\PD2conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] matrizFloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(matrizFloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
    }
}
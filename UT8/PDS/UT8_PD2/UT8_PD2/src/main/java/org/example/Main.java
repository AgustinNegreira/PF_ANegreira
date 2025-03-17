package org.example;

public class Main {
    public static void main(String[] args) {
        TGrafoNoDirigido grafoND = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD2\\UT8_PD2\\src\\main\\java\\org\\example\\verticesAAM.txt","D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD2\\UT8_PD2\\src\\main\\java\\org\\example\\conexionesAAM.txt",
                false, TGrafoNoDirigido.class);
        System.out.println("UT8 PD1");
        System.out.println("Ejercicio 1 Parte 2 ");
        TGrafoNoDirigido grafoKruskal = grafoND.Kruskal();
        System.out.println("AAM a partir de Kruskal: " + grafoKruskal.getCostoTotal());
        grafoND.desvisitarVertices();

        System.out.println("Ejercicio 1 Parte 3 ");
        TGrafoNoDirigido grafoPrim2 = grafoND.Prim();
        System.out.println("AAM a partir de Prim: " + grafoPrim2.getCostoTotal());
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(grafoPrim2.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafoPrim2.getVertices(), "Matriz Prim");
    }
}
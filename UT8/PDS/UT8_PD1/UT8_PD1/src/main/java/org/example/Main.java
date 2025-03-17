package org.example;

public class Main {
    public static void main(String[] args) {

        // UT8 PD1 Ejercicio 2
        System.out.println("Ejercicio 2");
        TGrafoNoDirigido grafoND = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD1\\UT8_PD1\\src\\main\\java\\org\\example\\verticesAAM.txt","D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD1\\UT8_PD1\\src\\main\\java\\org\\example\\conexionesAAM.txt",
                false, TGrafoNoDirigido.class);

        TGrafoNoDirigido grafoPrim2 = grafoND.Prim();
        System.out.println("AAM a partir de Prim: " + grafoPrim2.getCostoTotal());
        grafoND.desvisitarVertices();
        TGrafoNoDirigido grafoKruskal = grafoND.Kruskal();
        System.out.println("AAM a partir de Kruskal: " + grafoKruskal.getCostoTotal());

        System.out.println("\n==========");

        // UT8 PD1 Ejercicio 3
        System.out.println("Ejercicio 3");
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD1\\UT8_PD1\\src\\main\\java\\org\\example\\verticesBEA_1.txt", "D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT8\\PDS\\UT8_PD1\\UT8_PD1\\src\\main\\java\\org\\example\\aristasBEA_1.txt",
                false, TGrafoNoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gnd.getVertices(), "Matriz");


    }
}
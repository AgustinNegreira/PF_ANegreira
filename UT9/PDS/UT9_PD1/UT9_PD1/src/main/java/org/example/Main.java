package org.example;

public class Main {

    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        /*
        // INSERTION SORT
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        int[] resAleatorio = clasif.clasificar(vectorAleatorio, 1);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.print(resAleatorio[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resAleatorio));

        int[] resAscendente = clasif.clasificar(vectorAscendente, 1);
        for (int i = 0; i < resAscendente.length; i++) {
            System.out.print(resAscendente[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resAscendente));

        int[] resDescendente = clasif.clasificar(vectorDescendente, 1);
        for (int i = 0; i < resDescendente.length; i++) {
            System.out.print(resDescendente[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resDescendente));
        */

        /*
        // SHELL SORT
        int[] vectorAleatorio2 = gdg.generarDatosAleatorios();
        int[] vectorAscendente2 = gdg.generarDatosAscendentes();
        int[] vectorDescendente2 = gdg.generarDatosDescendentes();

        int[] resAleatorio2 = clasif.clasificar(vectorAleatorio2, 2);
        for (int i = 0; i < resAleatorio2.length; i++) {
            System.out.print(resAleatorio2[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resAleatorio2));

        int[] resAscendente2 = clasif.clasificar(vectorAscendente2, 2);
        for (int i = 0; i < resAscendente2.length; i++) {
            System.out.print(resAscendente2[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resAscendente2));

        int[] resDescendente2 = clasif.clasificar(vectorDescendente2, 2);
        for (int i = 0; i < resDescendente2.length; i++) {
            System.out.print(resDescendente2[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resDescendente2));
         */

        // BUBBLE SORT
        int[] vectorAleatorio3 = gdg.generarDatosAleatorios();
        int[] vectorAscendente3 = gdg.generarDatosAscendentes();
        int[] vectorDescendente3 = gdg.generarDatosDescendentes();

        int[] resAleatorio3 = clasif.clasificar(vectorAleatorio3, 3);
        for (int i = 0; i < resAleatorio3.length; i++) {
            System.out.print(resAleatorio3[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resAleatorio3));

        int[] resAscendente3 = clasif.clasificar(vectorAscendente3, 3);
        for (int i = 0; i < resAscendente3.length; i++) {
            System.out.print(resAscendente3[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resAscendente3));

        int[] resDescendente3 = clasif.clasificar(vectorDescendente3, 3);
        for (int i = 0; i < resDescendente3.length; i++) {
            System.out.print(resDescendente3[i] + " ");
        }
        System.out.println();
        System.out.println(TClasificador.estaOrdenado(resDescendente3));
    }
}
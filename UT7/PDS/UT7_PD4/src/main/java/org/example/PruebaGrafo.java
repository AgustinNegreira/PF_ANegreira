package org.example;

import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT7\\UT7_PD4\\src\\main\\java\\org\\example\\aeropuertos_1.txt", "D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT7\\UT7_PD4\\src\\main\\java\\org\\example\\conexiones_1.txt",
                false, TGrafoDirigido.class);

        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // imprimir etiquetas del bpf desde Asunción....
        for (TVertice etVert : recorrido_Asuncion) {
            System.out.print(etVert + " ");
        }

        TCaminos caminos = gd.todosLosCaminos("Santos", "Curitiba");
        caminos.imprimirCaminosConsola();
    }
}
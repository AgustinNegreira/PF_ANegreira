package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();

        String[] abonadosArchivo = ManejadorArchivosGenerico.leerArchivo(
                "D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT5\\UT5_PD7\\src\\main\\java\\org\\example\\abonados.txt");
        for (String str : abonadosArchivo) {
            String[] elementos = str.split(",");
            String telefono = elementos[0];
            String nombre = elementos[1];
            TAbonado abonado = new TAbonado(nombre, telefono);
            trie.insertar(abonado);

        }

        String codigoPais = "054" ;
        String codigoArea = "90" ;
        LinkedList<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);

        // guardar abonados en salida.txt, correspondientes al pais y area
        String[] lista = new String[ab.size()];
        int indice = 0;

        for (TAbonado a : ab) {
            String nombre = a.getNombre();
            String telefono = a.getTelefono();
            String abonado = nombre + ", " + telefono;
            lista[indice] = abonado;
            indice++;
        }

        Arrays.sort(lista);

        ManejadorArchivosGenerico.escribirArchivo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT5\\UT5_PD7\\src\\main\\java\\org\\example\\salida.txt", lista);
    }
}
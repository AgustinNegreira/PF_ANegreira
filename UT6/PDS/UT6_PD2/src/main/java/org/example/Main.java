package org.example;

public class Main {
    public static void main(String[] args) {
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"

        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        String clavesInsertar[] = ManejadorArchivosGenerico.leerArchivo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT6\\UT6_PD2\\src\\main\\java\\org\\example\\claves_insertar.txt");
        String clavesBuscar[] = ManejadorArchivosGenerico.leerArchivo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT6\\UT6_PD2\\src\\main\\java\\org\\example\\claves_buscar.txt");
        int factor = 70;

        int i = 0;
        StringBuilder texto = new StringBuilder();
        texto.append("Factor\tCompI\tCompBE\tCBNExit\n");
        String[] lineas = new String[15];
        lineas[i++] = "factor,compInser,compBusExit,compBusNoExit";
        System.out.println("Factor\tCompI\tCBExit\tCBNExit");
        while (factor < 100){
            int compInsertar = 0;
            int compBuscar = 0;
            int tamanio = (int) Math.round(100*clavesInsertar.length/factor);
            THash tablaHash = new THash(tamanio);
            if (factor < 90){
                for(String clave : clavesInsertar) {
                    compInsertar += tablaHash.insertar(clave);
                }
                for(String clave : clavesBuscar) {
                    compBuscar += tablaHash.buscar(clave);
                }
                texto.append(factor + "\t" + (compInsertar/clavesInsertar.length) + "\t" + (tablaHash.busquedasExitosas/clavesInsertar.length) + "\t" + (tablaHash.busquedasNoExitosas/clavesInsertar.length)+"\n");
                lineas[i++] = factor + "," + (compInsertar/clavesInsertar.length) + "," + (tablaHash.busquedasExitosas/clavesInsertar.length) + "," + (tablaHash.busquedasNoExitosas/clavesInsertar.length);
                factor += 5;
            } else {
                for(String clave : clavesInsertar) {
                    compInsertar += tablaHash.insertar(clave);
                }
                for(String clave : clavesBuscar) {
                    compBuscar += tablaHash.buscar(clave);
                }
                texto.append(factor + "\t" + (compInsertar/clavesInsertar.length) + "\t" + (tablaHash.busquedasExitosas/clavesInsertar.length) + "\t" + (tablaHash.busquedasNoExitosas/clavesInsertar.length)+"\n");
                lineas[i++] = factor + "," + (compInsertar/clavesInsertar.length) + "," + (tablaHash.busquedasExitosas/clavesInsertar.length) + "," + (tablaHash.busquedasNoExitosas/clavesInsertar.length);
                factor += 1;
            }
        }
        System.out.println(texto.toString());
        ManejadorArchivosGenerico.escribirArchivo("D:\\UCU 4to semestre\\AED\\portafolio-AgustinNegreira\\UT6\\UT6_PD2\\src\\main\\java\\org\\example\\salida.csv",lineas);
    }
}
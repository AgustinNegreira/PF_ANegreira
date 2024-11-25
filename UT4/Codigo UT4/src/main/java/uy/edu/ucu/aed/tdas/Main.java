package uy.edu.ucu.aed.tdas;

/**
 *
 * @author ernesto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear el árbol binario de búsqueda
        TArbolBB<String> arbol = new TArbolBB<>();

        // Leer las claves desde el archivo "claves.txt"
        String[] claves = ManejadorArchivosGenerico.leerArchivo("D:\\UCU 4to semestre\\AED\\UT4\\ut04-m301-equipo-6\\src\\main\\java\\uy\\edu\\ucu\\aed\\tdas\\claves.txt");

        // Crear una lista para guardar el resultado
        String[] resultado = new String[claves.length];

        // Procesar cada clave
        for (int i = 0; i < claves.length; i++) {
            String clave = claves[i];
            boolean insertado = arbol.insertar(clave, null); // Asumimos que el valor es null
            resultado[i] = clave;
        }

        // Escribir el resultado en el archivo "resultado.txt"
        ManejadorArchivosGenerico.escribirArchivo("resultado.txt", resultado);

        System.out.println("Proceso completado. Verifique el archivo resultado.txt.");

        // Ruta de los archivos
        String archivoConsultas = "D:\\UCU 4to semestre\\AED\\UT4\\ut04-m301-equipo-6\\src\\main\\java\\uy\\edu\\ucu\\aed\\tdas\\consultas.txt";
        String archivoResultados = "resultados2.txt";

        // Crear un árbol binario de búsqueda
        TArbolBB<String> arbol2 = new TArbolBB<>();

        // Insertar algunos valores en el árbol (esto es solo un ejemplo)
        arbol2.insertar("clave1", "dato1");
        arbol2.insertar("clave2", "dato2");
        arbol2.insertar("clave3", "dato3");

        // Leer las consultas del archivo
        String[] consultas = ManejadorArchivosGenerico.leerArchivo(archivoConsultas);

        // Crear una lista para almacenar los resultados
        String[] resultados2 = new String[consultas.length];

        for (int i = 0; i < consultas.length; i++) {
            String clave = consultas[i].trim();
            Object resultado2 = arbol2.buscar(clave);
            if (resultado2 != null) {
                // Si se encontró la clave, poner 1 en el contador
                resultados2[i] = clave + " 1";
            } else {
                // Si no se encontró la clave, poner -1 en el contador
                resultados2[i] = clave + " -1";
            }
        }

        // Escribir los resultados en el archivo
        ManejadorArchivosGenerico.escribirArchivo(archivoResultados, resultados2);
    }

}

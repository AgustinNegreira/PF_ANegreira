package org.example;
import java.util.HashSet;
import java.util.Set;

public class ContadorPalabras {
    public static String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        // Crear conjuntos (Sets) a partir de los arrays
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // Agregar palabras del primer array al primer conjunto
        for (String palabra : palabras1) {
            set1.add(palabra);
        }

        // Agregar palabras del segundo array al segundo conjunto
        for (String palabra : palabras2) {
            set2.add(palabra);
        }

        // Encontrar la intersección de ambos conjuntos
        set1.retainAll(set2);

        // Convertir el conjunto de palabras comunes a un array
        return set1.toArray(new String[0]);
    }
}

/*
Precondición:
Los parámetros palabras1 y palabras2 son arrays de tipo String que pueden contener
cero o más palabras. No se garantiza que los arrays estén ordenados ni que
contengan elementos únicos.
Postcondición:
El metodo devuelve un array de tipo String que contiene las palabras que están
presentes en ambos arrays de entrada (palabras1 y palabras2).
El array de salida no contiene elementos duplicados y está compuesto únicamente
por las palabras que aparecen en ambos arrays.
Explicación breve:
El metodo palabrasComunes toma dos arrays de palabras y encuentra las palabras
que son comunes a ambos arrays. Utiliza conjuntos (Set) para almacenar las palabras
de cada array, lo que permite realizar una intersección eficiente.
Primero, convierte los arrays en conjuntos y luego realiza una operación de
intersección para obtener las palabras que están presentes en ambos conjuntos.
Finalmente, convierte el conjunto resultante de palabras comunes a un array de
String y lo devuelve como resultado.
 */

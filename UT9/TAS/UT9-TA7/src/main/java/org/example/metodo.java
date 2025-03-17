package org.example;

public class metodo {
    /**
     * Método que implementa el algoritmo de Cuenta por Distribución.
     * Este algoritmo organiza elementos en un rango conocido utilizando un arreglo auxiliar.
     * Funciona para ordenar números enteros en un rango acotado.
     *
     * @param datos        El arreglo de elementos a ordenar.
     * @param rangoMinimo  El valor mínimo esperado en los datos.
     * @param rangoMaximo  El valor máximo esperado en los datos.
     * @return Un nuevo arreglo ordenado.
     */
    public static int[] cuentaPorDistribucion(int[] datos, int rangoMinimo, int rangoMaximo) {
        // Validar entrada
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío.");
        }
        if (rangoMinimo > rangoMaximo) {
            throw new IllegalArgumentException("El rango mínimo no puede ser mayor al máximo.");
        }

        // Paso 1: Crear el arreglo auxiliar para contar ocurrencias
        int rango = rangoMaximo - rangoMinimo + 1; // Determinar el tamaño del rango
        int[] cuenta = new int[rango]; // Inicializar el arreglo de conteo

        // Contar las ocurrencias de cada elemento en el rango
        for (int i = 0; i < datos.length; i++) {
            cuenta[datos[i] - rangoMinimo]++;
        }

        // Paso 2: Acumular las cuentas para determinar posiciones finales
        for (int i = 1; i < cuenta.length; i++) {
            cuenta[i] += cuenta[i - 1];
        }

        // Paso 3: Crear el arreglo de salida y ubicar elementos en orden
        int[] resultado = new int[datos.length]; // Arreglo para los datos ordenados
        for (int i = datos.length - 1; i >= 0; i--) { // Recorremos de derecha a izquierda
            int valor = datos[i]; // Valor actual del dato
            resultado[cuenta[valor - rangoMinimo] - 1] = valor; // Ubicar en el lugar correspondiente
            cuenta[valor - rangoMinimo]--; // Reducir la cuenta disponible
        }

        return resultado; // Retornar el arreglo ordenado
    }

}

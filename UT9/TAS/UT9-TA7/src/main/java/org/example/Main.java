package org.example;

public class Main {
    public static void main(String[] args) {
        // Datos a ordenar
        int[] datos = {5, 3, 7, 9, 3, 5, 1, 4};
        int rangoMinimo = 1; // Valor mínimo en el rango
        int rangoMaximo = 9; // Valor máximo en el rango

        // Llamar al método cuentaPorDistribucion
        int[] resultadoOrdenado = cuentaPorDistribucion(datos, rangoMinimo, rangoMaximo);

        // Mostrar el resultado ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : resultadoOrdenado) {
            System.out.print(num + " ");
        }
    }

    /**
     * Método que implementa el algoritmo de Cuenta por Distribución.
     * (Definido aquí mismo para que sea ejecutable por separado).
     */
    public static int[] cuentaPorDistribucion(int[] datos, int rangoMinimo, int rangoMaximo) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío.");
        }
        if (rangoMinimo > rangoMaximo) {
            throw new IllegalArgumentException("El rango mínimo no puede ser mayor al máximo.");
        }

        int rango = rangoMaximo - rangoMinimo + 1;
        int[] cuenta = new int[rango];
        for (int i = 0; i < datos.length; i++) {
            cuenta[datos[i] - rangoMinimo]++;
        }

        for (int i = 1; i < cuenta.length; i++) {
            cuenta[i] += cuenta[i - 1];
        }

        int[] resultado = new int[datos.length];
        for (int i = datos.length - 1; i >= 0; i--) {
            int valor = datos[i];
            resultado[cuenta[valor - rangoMinimo] - 1] = valor;
            cuenta[valor - rangoMinimo]--;
        }

        return resultado;
    }
}

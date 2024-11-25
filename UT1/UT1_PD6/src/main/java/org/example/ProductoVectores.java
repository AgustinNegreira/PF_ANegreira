package org.example;

public class ProductoVectores {

    public static void multiplicarVectores(int[] vector1, int[] vector2) {
        if (vector1.length == vector2.length) {
            int result = 0;
            for (int i = 0; i < vector1.length; i++) {
                result += vector1[i] * vector2[i];
            }
            System.out.println("El producto escalar de los vectores es: " + result);
        } else {
            System.out.println("Los vectores no pueden ser multiplicados. Asegúrate de que tengan la misma longitud.");
        }
    }

    public static void main(String[] args) {
        int[] vector1 = {2, 4, 6};
        int[] vector2 = {1, 3, 5};
        multiplicarVectores(vector1, vector2);
    }
}


/*
Precondición:
Se tienen dos vectores de tipo int (arreglos unidimensionales) con el mismo número de elementos.

Postcondición:
Si los vectores tienen la misma longitud, se devuelve el producto escalar como un valor entero.
Si los vectores no tienen la misma longitud, se muestra un mensaje indicando que la operación no es posible.

Explicación breve:
El programa verifica primero si los vectores tienen la misma longitud. Si esta condición se cumple, calcula
el producto escalar sumando los productos de los elementos correspondientes de los dos vectores. Si la
condición no se cumple, el programa informa al usuario que la multiplicación no es posible.
 */
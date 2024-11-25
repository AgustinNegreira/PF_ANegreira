package org.example;

// Ejercicio 3
public class Student {

    public static void main(String[] args) {
        String[] students = new String[10];
        String studentName = "Peter Parker";
        students[0] = studentName;
        studentName = null;
    }
}

/*
1) En una primera instancia existe 1 referencia para el array de Strings\
y 2 referencias para el objeto "Peter Parker", 1 en la posicion 0 del array
y otra en la variable studentName, pero luego de que la variable studentName
sea declarada como nula, solamente le queda 1 referencia. Como ambos objetos
en el programa siguen teniendo referencias ninguno es candidado para ser
recolectado por el GC.

2) Para eliminar un objeto en Java, se utiliza el Garbage Collector, una herramienta
automática que detecta cuando un objeto ya no tiene referencias activas apuntando a él.
Esto significa que el objeto no puede ser accedido ni utilizado por ninguna parte del
programa, lo que lo convierte en memoria que debe ser liberada. El Garbage Collector se
encarga de liberar esa memoria de manera eficiente para evitar que ocupe espacio de
manera innecesaria, contribuyendo a la gestión automática de la memoria en Java.
 */

package org.example;

// Ejercicio 4
public class ValueOfDemo {
    public static void main(String[] args) {
        // this program requires two
        // arguments on the command line
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue();
            // do some arithmetic
            System.out.println("a + b = " +
                    (a + b));
            System.out.println("a - b = " +
                    (a - b));
            System.out.println("a * b = " +
                    (a * b));
            System.out.println("a / b = " +
                    (a / b));
            System.out.println("a % b = " +
                    (a % b));
        } else {
            System.out.println("This program " +
                    "requires two command-line arguments.");
        }
    }
}

/*
1) La salida es:
a + b = 79.5
a - b = -52.699997
a * b = 885.7399
a / b = 0.20272315
a % b = 13.4

2) Se deberian modificar las variables que contienen a los argumentos.
Actuales lineas de codigo:
float a = (Float.valueOf(args[0])).floatValue();
float b = (Float.valueOf(args[1])).floatValue();

Nuevas lineas de codigo:
int a = Integer.valueOf(args[0]);
int b = Integer.valueOf(args[1]);
 */

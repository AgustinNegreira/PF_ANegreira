package org.example;

// Ejercicio 5
public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.');
        System.out.println(dot + " digits before decimal point.");
        System.out.println( (s.length() - dot - 1) + " digits after decimal point.");
    }
}

/*
1) 3 digits before decimal point.
2 digits after decimal point.
2)
dot (número de punto decimal):

Double.toString(d) convierte el número d (888.51) a su representación en forma de cadena (String s).
s.indexOf('.') busca la posición del punto decimal en la cadena s.
En este caso específico, s será "888.51", por lo que indexOf('.') devolverá 3, que es la posición del punto decimal dentro de la cadena.
Por lo tanto, dot será igual a 3.
Cantidad de dígitos antes del punto decimal:

System.out.println(dot + " digits " + "before decimal point."); imprime el valor de dot seguido por la cadena " digits before decimal point.".
Dado que dot es 3, la salida será "3 digits before decimal point.".
Esto indica que hay 3 dígitos en la parte entera del número 888.51 antes del punto decimal.
Cantidad de dígitos después del punto decimal:

System.out.println( (s.length() - dot - 1) + " digits after decimal point."); calcula cuántos dígitos hay después del punto decimal.
s.length() devuelve la longitud total de la cadena s, que es 6 en este caso ("888.51").
s.length() - dot - 1 calcula cuántos caracteres hay después del punto decimal, restando la posición del punto (dot) y 1 adicional para contar el punto mismo.
En este caso, 6 - 3 - 1 = 2, lo que significa que hay 2 dígitos después del punto decimal en el número 888.51.
La salida será "2 digits after decimal point.".
 */
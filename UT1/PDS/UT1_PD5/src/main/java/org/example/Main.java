package org.example;
// Ejercicio 1 parte 1)
public class Main {

    public enum Dia {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    public static void main(String[] args) {
        // Recorrer el array y mostrar cada valor
        for (Dia dia : Dia.values()) {
            System.out.println(dia);
        }

        System.out.println(ContadorVocales.contarVocales("hola"));

        String original = "este es el curso de Programación 2";
        StringBuilder result = new StringBuilder("hola");
        int index = original.indexOf('a'); // 25
        /*1*/ result.setCharAt(0, original.charAt(0)); //eola
        /*2*/ result.setCharAt(1, original.charAt(original.length()-1)); //e2la
        /*3*/ result.insert(1, original.charAt(4)); //e2 la
        /*4*/ result.append(original.substring(1,4)); //e2 laste
        /*5*/ result.insert(3, (original.substring(index, index+2) + " ")); //e 2am laste
        System.out.println(result);

    }
}
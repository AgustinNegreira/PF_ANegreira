package org.example;
// Ejercicio 1 parte 2)

public class ContadorVocales {

    public enum Vocales {
        A,E,I,O,U
    }
    public static String contarVocales(String frase){
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        String fraseIterable = frase.toUpperCase();
        for (char letra : fraseIterable.toCharArray()) {
            boolean esVocal = false;
            for (Vocales v : Vocales.values()) {
                if (letra == v.name().charAt(0)) {
                    esVocal = true;
                    break; // Salir del bucle interno si encontramos una vocal
                }
            }
            // Incrementar contador de vocales si se identificó como vocal
            if (esVocal) {
                contadorVocales++;
            }
            // Incrementar contador de consonantes si es una letra y no es una vocal
            else if (Character.isLetter(letra)) {
                contadorConsonantes++;
            }
        }
        return ("La cantidad de vocales es: " + contadorVocales + ", y la cantidad de consonantes es: " + contadorConsonantes);
    }
}

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContadorPalabras {
    // Ejercicio 1 del TA3
    public int contarPalabras (String frase) {
        int contadorPalabras = 0;
        String palabraTemp = "";

        for (char letra : frase.toCharArray()) {
            // Comprueba los principales signos de puntuación y espacios
            if (letra != ' ' && letra != '.' && letra != ',' && letra != ':' && letra != ';' && letra != '\n') {
                palabraTemp += letra;
            } else {
                contadorPalabras += validarPalabra(palabraTemp);
                palabraTemp = "";
            }
        }

        // Validación para la última palabra en la cadena
        contadorPalabras += validarPalabra(palabraTemp);

        return contadorPalabras;
    }

    private int validarPalabra(String palabra) {
        if (!palabra.isEmpty()) {
            for (char letra : palabra.toCharArray()) {
                if (Character.isLetter(letra)) {
                    return 1; // Retorna 1 si la palabra es válida
                }
            }
        }
        return 0; // Retorna 0 si la palabra no es válida
    }

    // Ejercicio 2 del TA3, parte del subgrupo B
    public String contadorPalabrasLargoEspecifico (String frase, int x) {
        int contadorPalabras = 0;
        String palabraTemp = "";

        for (char letra : frase.toCharArray()) {
            if (letra != ' ' && letra != '.' && letra != ',' && letra != ':' && letra != ';'){
                palabraTemp += letra;
            }
            else {
                boolean palabraValida = false;
                for (char letra2 : palabraTemp.toCharArray()) {
                    if(Character.isLetter(letra2)){
                        palabraValida = true;
                    }
                }
                if(palabraValida){
                    if (palabraTemp.length() > x) {
                        contadorPalabras+=1;
                    }
                    palabraValida = false;
                }
                palabraTemp = "";
            }
        }

        return "El String tiene " + contadorPalabras + " palabras con largo mayor a " + x;
    }

    // Ejercicio 3 del TA3
    public String[] obtenerLineas(String archivo) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprime la cantidad de líneas leídas
        System.out.println("Cantidad de líneas leídas: " + lineas.size());

        return lineas.toArray(new String[0]);
    }

    public int cantPalabras(String[] lineasArchivo) {
        int contador = 0;

        for (String linea : lineasArchivo) {
            contador += contarPalabras(linea);
        }

        return contador;
    }

    public static void main (String args[]) {
        ContadorPalabras contador = new ContadorPalabras();
        System.out.println(contador.contarPalabras("Si piens4as que tu prof.esor es exigente,..." +
                " espera a concer a tu jefe !"));
        System.out.println(contador.contadorPalabrasLargoEspecifico("hola como te encuentras bro", 4));

        String[] lineas = contador.obtenerLineas("src/main/java/org/example/archivo.txt");
        System.out.println("Cantidad de palabras: " + contador.cantPalabras(lineas));
    }
}
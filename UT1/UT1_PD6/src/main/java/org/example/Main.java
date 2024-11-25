package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        imprimirTablero(7, 7);
        leerEntradaArchivo("src/main/java/org/example/archivo.txt");
        leerEntradaStdin();
        transformarTextoT9("src/main/java/org/example/entrada.txt");
    }

    // Ejercicio 1
    public static void imprimirTablero(int largo, int ancho){
        for (int i = 0; i < largo; i++){
            for (int j = 0; j <= ancho; j++){
                if (j == ancho){
                    System.out.print('\n');
                }
                else{
                    System.out.print('#');
                }
            }
        }
    }
    // Ejercicio 2 parte a)
    public static void leerEntradaArchivo(String rutaArchivo){
        List<String> lineas = null;
        try {
            lineas = Files.readAllLines(Paths.get(rutaArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String integer = lineas.get(0);
        String flotante = lineas.get(1);
        String cadena = lineas.get(2);
        System.out.println("El entero leido es: " + integer);
        System.out.println("El numero de punto flotante es: " + flotante);
        System.out.println("La cadena leida es \"" + cadena + "\"");
        System.out.println("¡Hola " + cadena + "! La suma de " + integer + " y " + flotante + " es " + (Float.parseFloat(integer ) + Float.parseFloat(flotante)));
        System.out.println("La division entera de " + flotante + " y " + integer + " es " + (int) (Float.parseFloat(flotante) / Float.parseFloat(integer)) + " y su resto es " + (Float.parseFloat(flotante) % Float.parseFloat(integer)));
    }

    // Ejercicio 2 parte b)
    public static void leerEntradaStdin() {
        // Crear un objeto Scanner para leer desde stdin
        Scanner scanner = new Scanner(System.in);

        // Solicitar el radio al usuario
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();

        // Calcular el área
        double area = Math.PI * Math.pow(radio, 2);

        // Calcular el perímetro (circunferencia)
        double perimetro = 2 * Math.PI * radio;

        // Imprimir los resultados
        System.out.println("Área de la circunferencia: " + area);
        System.out.println("Perímetro de la circunferencia: " + perimetro);
    }

    // Ejercicio 3 parte a)
    // Mensaje de entrada es "Hola."
    // Mensaje de salida deberia ser: 4466655521
    public static void transformarTextoT9(String rutaArchivo) {
        String archivoEntrada = rutaArchivo;
        String archivoSalida = "src/main/java/org/example/salida.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Transforma la línea y escribe en el archivo de salida
                String transformedLine = transformLine(line);
                writer.write(transformedLine);
                writer.newLine();
            }

            System.out.println("Transformación completada. Verifica el archivo salida.txt.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String transformLine(String line) {
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            char upperChar = Character.toUpperCase(c);
            if (t9Map.containsKey(upperChar)) {
                sb.append(t9Map.get(upperChar));
            }
        }
        return sb.toString();
    }

    // Mapa para la conversión de caracteres a dígitos T9
    private static final Map<Character, String> t9Map = new HashMap<>();

    static {
        // Inicializa el mapa con las letras y los dígitos correspondientes
        t9Map.put('A', "2");
        t9Map.put('B', "22");
        t9Map.put('C', "222");
        t9Map.put('D', "3");
        t9Map.put('E', "33");
        t9Map.put('F', "333");
        t9Map.put('G', "4");
        t9Map.put('H', "44");
        t9Map.put('I', "444");
        t9Map.put('J', "5");
        t9Map.put('K', "55");
        t9Map.put('L', "555");
        t9Map.put('M', "6");
        t9Map.put('N', "66");
        t9Map.put('O', "666");
        t9Map.put('P', "7");
        t9Map.put('Q', "77");
        t9Map.put('R', "777");
        t9Map.put('S', "7777");
        t9Map.put('T', "8");
        t9Map.put('U', "88");
        t9Map.put('V', "888");
        t9Map.put('W', "9");
        t9Map.put('X', "99");
        t9Map.put('Y', "999");
        t9Map.put('Z', "9999");
        // Agrega los caracteres especiales
        t9Map.put(' ', "0");
        t9Map.put('.', "1");
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        int holaHC = "Hola".hashCode();
        int holaMundoHC = "HolaMundo".hashCode();
        int hashMapHC = "HashMap".hashCode();
        int coleccionesHC = "Colecciones".hashCode();

        System.out.println("Hola: " + holaHC );
        System.out.println("HolaMundo: "+ holaMundoHC);
        System.out.println("HashMap: "+ hashMapHC);
        System.out.println("Colecciones: "+ coleccionesHC);

        Alumno juan = new Alumno(1234, "Agustin Negreira", "agustin.negreira@correo.ucu.edu.uy");
        System.out.println(juan.hashCode());
        System.out.println(juan.equals(new Alumno(123, "Agustin Negreira", "agustin.negreira@correo.ucu.edu.uy")));
    }
}
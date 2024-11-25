package org.example;

public class Main {
    public static void main(String[] args) {
        TArbolGenerico ar = new TArbolGenerico();
        // Rectoria, la raiz
        ar.insertar("RECTORIA", "");
        System.out.println(ar.listarIndentado());
        // Vicerectoerias
        ar.insertar("VICERRECTORIA DEL MEDIO UNIVERSITARIO","RECTORIA");
        ar.insertar("VICERRECTORIA ACADEMICA","RECTORIA");
        ar.insertar("VICERRECTORIA ADMINISTRATIVA","RECTORIA");
        System.out.println(ar.listarIndentado());
        // Facultades
        ar.insertar("FACULTAD DE CIENCIAS EMPRESARIALES","VICERRECTORIA ACADEMICA");
        ar.insertar("FACULTAD DE CIENCIAS HUMANAS","VICERRECTORIA ACADEMICA");
        ar.insertar("FACULTAD DE INGENIERIA Y TECNOLOGIAS","VICERRECTORIA ACADEMICA");
        ar.insertar("FACULTAD DE PSICOLOGIA","VICERRECTORIA ACADEMICA");
        System.out.println(ar.listarIndentado());
        // Departamentos
        ar.insertar("DEPARTAMENTO DE INFORMATICA Y CIENCIAS DE LA COMPUTACION","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        ar.insertar("DEPARTAMENTO DE INGENIERIA ELECTRICA","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        ar.insertar("DEPARTAMENTO DE MATEMATICAS","FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        System.out.println(ar.listarIndentado());

        // Busqueda exitosa
        TNodoGenerico nodoC = ar.buscar("FACULTAD DE INGENIERIA Y TECNOLOGIAS");
        System.out.println("Busqueda exitosa: " + nodoC.getEtiqueta());

        // Busqueda erronea
        System.out.println("Busqueda erronea: " + ar.buscar("FACULTAD"));
    }
}
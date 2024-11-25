package org.example;

public class THashMap implements IHashMap {

    String[] tabla;
    int tamanio;
    public static int busquedasNoExitosas = 0;
    public static int busquedasExitosas = 0;
    
    public THashMap(int tamanio) {
        this.tabla = new String[tamanio];
        this.tamanio = tamanio;
    }

    @Override
    public int buscar(String unaClave) {
        int comparaciones = 1;
        int i = 0;
        int j = this.funcionHashing(unaClave);
        
        while(comparaciones <= 200) {      
            j = (this.funcionHashing(unaClave) + i) % this.tamanio;
            
            if (this.vacio(this.tabla[j])) {
                System.out.println("Elemento " + unaClave + " no encontrado");
                busquedasNoExitosas += comparaciones;
                return comparaciones;
            }
            if (this.tabla[j].equals(unaClave)) {
                System.out.println("Elemento " + unaClave + " encontrado en la posicion: " + j);
                busquedasExitosas += comparaciones;
                return comparaciones;
            } else {
                i += 1;
                comparaciones += 1;
            }            
        }
        System.out.println("Elemento " + unaClave + " no encontrado");
        busquedasNoExitosas += comparaciones;
        return comparaciones;
    }

    @Override
    public int insertar(String unaClave) {
        int comparaciones = 1;
        int i = 0;
        int j = 0;
        
        while(comparaciones <= 200) {      
            j = (this.funcionHashing(unaClave) + i) % this.tamanio;
            
            if (this.vacio(this.tabla[j])) {
                this.tabla[j] = unaClave;
                return comparaciones;
            } else {
                i += 1;
                comparaciones += 1;
            }            
        }
        System.out.println("Sobrecarga de la tabla hash.");
        return comparaciones;
    }

    @Override
    public int funcionHashing(String unaClave) {
        int resultado = 0;
        char primerChar = unaClave.charAt(0);
        int asciiChar = (int) primerChar; // Convierte el primer caracter en su respectivo ASCII.

        resultado = (asciiChar * 3) % this.tamanio;

        return resultado;
    }

    private boolean vacio(String elemento) {
        return elemento == null;
    }
    
    public int size() {
        int size = 0;
        for (String valorTabla : this.tabla) {
            if (!vacio(valorTabla)) {
                size++;
            }
        }
        return size;
    }
    
    public int espaciosLibres() {
        int libres = 0;
        for (String valorTabla : this.tabla) {
            if (vacio(valorTabla)) {
                libres++;
            }
        }
        return libres;
    }
}
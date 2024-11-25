package org.example;

// Ejercicio 4
public class Alumno {
    private String nombre;

    public Alumno() {
        nombre = "";
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
        System.out.println(recorrer("hola"));
        System.out.println(getValor());
        System.out.println(getPrimerCaracter("Hola"));
        System.out.println(paraAString(5));
    }

    public static int recorrer(String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = {6, 16, 26, 36, 46, 56, 66, 76};
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        return (palabra.charAt(0));
    }

    public static String paraAString(int a) {
        return String.valueOf(a);
    }
}

/*
a) No se puede concatenar con un valor que sea nulo, tal como se define en el constructor.
b) Genera un error ya que el metodo charAt utiliza indice 0, entonces al lleagr al final
de la cadena genera una excepion por estar fuera de rango.
c) Se le esta pidiendo mal el valor ya que los indices validos van de 0 a 7, por lo cual se
deberia pedir el 7 si se quisiera el ultimo, no el 8, asi no genera una excepcion
d) En ningun momento se asigna la variable palabra al array que se esta utilizando. En ese
caso lo mejor es quitar toda la implementacion que no es necesaria y directamente trabajar
sobre la variable "palabra". Ahora si, indicando el indice 0, ya que como mencione anteriormente
Java es cero-based en terminos de indices.
e) Se intenta convertir de int a string de forma incorrecta y poco eficiente. Es mejor usar valueof
debido a su versatilidad con todos los tipos de datos primitivos, tal como es en este caso un int.

 */
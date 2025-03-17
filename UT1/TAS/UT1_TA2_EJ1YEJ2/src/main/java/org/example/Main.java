package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(isPrimeSum(10));
    }
    // Ejercicio 1
    public static int factorial(int num) {
        int resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Ejercicio 2
    public static String isPrimeSum(int n) {
        boolean prime = true;

        if (n <= 1) {
            prime = false;
        }

        int i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                prime = false;  // Si tiene un divisor, no es primo
            }
            i++;
        }

        if (prime) {
            int suma = 0;
            int a = 0;
            while(a<=n){
                suma += a;
                a+=2;
            }
            System.out.println(n + " Es primo");
            return "La suma es: " + suma;
        }
        else {
            int suma = 0;
            int a = 1;
            while(a<=n){
                suma += a;
                a+=2;
            }
            System.out.println(n + " No es primo");
            return "La suma es: " + suma;
        }
    }
}
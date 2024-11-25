package org.example;
import java.awt.Rectangle;

// Ejercicio 2
public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + area(myRect));
    }

    public static int area(Rectangle myrect) {
        return myrect.width * myrect.height;
    }
}

/*
El programa estaba mal porque no instanciaba un objeto de la clase Rectangle y porque
no tenia un metodo "area" para calcular el area del rectangulo, asi que instanciamos
el objeto y creamos el metodo para poder calcular el area del mismo.
 */
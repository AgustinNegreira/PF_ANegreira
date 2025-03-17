package org.example;

public class Marcapasos {
    short presionSanguinea; // usamos short para poder almacenar un dato como 250 utilizando la menor cantidad de memoria posible
    short frecuenciaCardiaca; // usamos short para poder almacenar un dato como 226 utilizando la menor cantidad de memoria posible
    short nivelAzucarEnSangre; // usamos short para poder almacenar un dato como 1000 utilizando la menor cantidad de memoria posible
    long maximaFuerzaExposicion; // usamos long para poder almacenar un dato como 3000000000 utilizando la menor cantidad de memoria posible
    float minimoTiempoEntreLatidos; // usamos float para poder almacenar un dato con decimales utilizando la menor cantidad de memoria posible
    double bateriaRestante; // usamos double, sacrificando mayor uso de memoria pero teniendo mayor precision en decimales
    char[] codigoFabricante; //usamos un array de caracteres ya que teniendo en cuenta que el maximo largo es de 8, siempre va a ocupar menos memoria que un String.

    /*
    Un objeto de esta clase consumiria (en termino de variables) aproximadamente lo siguiente:

    3 Variables short: 6 bytes (Cada una de 2 bytes)
    Variable long: 8 bytes
    Variable float: 4 bytes
    Variable double: 8 bytes
    Array char[]: 24 bytes (16 bytes como maximo para los caracteres + 8 bytes de overhead)
    Suma Total: 6 + 8 + 4 + 8 + 24 = 50 bytes (considerando que el codigo es de largo 8)
     */
}

package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Conjunto{
    public Lista conjuntos = new Lista();
    public String nombre;
    public String[] conjunto;
    
    public Conjunto(String nombre, String[] conj){
        this.nombre = nombre;
        this.conjunto = conj;
    }
    
    public void insertConj2List(){
        if (conjunto != null){
            for (int i = 0; i < conjunto.length ; i++){
                Nodo nuevoNodo = new Nodo(conjunto[i],i);
                conjuntos.insertar(nuevoNodo);
            }
            System.out.println("Se ha generado la lista enlazada a partir"
                + " del conjunto");
        }
        
    }
    
    public Conjunto union(Conjunto otroConjunto){
        ArrayList arrL = new ArrayList(Arrays.asList(this.conjunto));
        String[] otroConj = otroConjunto.conjunto;
        String[] union = new String[arrL.size()];
        arrL.toArray(union);
        for (String otroConj1 : otroConj) {
            if (!arrL.contains(otroConj1)) {
                arrL.add(otroConj1);
            }
        }
        String[] nuevo = new String[arrL.size()];
        arrL.toArray(nuevo);
        
        Arrays.parallelSort(nuevo);
        System.out.println(arrL.size());
        
        Conjunto nuevoConj = new Conjunto("Union", nuevo);
        nuevoConj.insertConj2List();
        return nuevoConj;
    }
    
    public Conjunto interseccion ( Conjunto otroConjunto){
        ArrayList arrL = new ArrayList(Arrays.asList(this.conjunto));
        ArrayList interL = new ArrayList();
        String[] otroConj = otroConjunto.conjunto;
        String[] inter = new String[arrL.size()];
        arrL.toArray(inter);
        for (String otroConj1 : otroConj) {
            if (arrL.contains(otroConj1)) {
                interL.add(otroConj1);
            }
        }
        String[] nuevo = new String[interL.size()];
        interL.toArray(nuevo);
        
        Arrays.parallelSort(nuevo);
        System.out.println(interL.size());
        
        Conjunto nuevoConj = new Conjunto("Union", nuevo);
        nuevoConj.insertConj2List();
        return nuevoConj;
    }
   
}

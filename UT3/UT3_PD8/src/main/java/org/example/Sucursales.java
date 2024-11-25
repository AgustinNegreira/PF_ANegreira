package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Sucursales {
    public ArrayList sucursales;
    private int cantSuc;
    
    public void insertArrayList(String directorio){
        String[] arr = ManejadorArchivosGenerico.leerArchivo(directorio);
        this.sucursales = new ArrayList(Arrays.asList(arr));
        this.cantSuc = this.cantSuc + arr.length;
    }
    
    public void agregarSuc(String nuevaSuc){
        if (!this.sucursales.contains(nuevaSuc)){
            this.sucursales.add(nuevaSuc);
            System.out.println("Se agrego la Sucursal: " + nuevaSuc);
            this.cantSuc++;
        }else{
            System.out.println("La sucursal ya se encontraba en la lista.");
        }
    }
    
    public String buscar(String nombre){
        if (this.sucursales.contains(nombre)){
            return nombre;
        }
        System.out.println("No se encontro la sucursal buscada.");
        return null;
    }
    
    public boolean eliminar (String nombre){
        if (this.sucursales.contains(nombre)){
            this.sucursales.remove(nombre);
            System.out.println("Se elimino " + nombre);
            this.cantSuc--;
            return true;
        }
        System.out.println("No se elimino " + nombre 
                + " porque no estaba en la lista.");
        return false;
    }
    
    public String imprimir(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.sucursales.size(); i++){
            sb.append(this.sucursales.get(i));
            sb.append("-->");
        }
        return sb.toString();
    }
    public String imprimir(String separador){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.sucursales.size(); i++){
            sb.append(this.sucursales.get(i));
            sb.append(separador);
        }
        return sb.toString();
    }
    
    public void cantidadSucursales(){
        System.out.println(cantSuc);
    }
    
    public boolean esVacio(){
        return this.cantSuc == 0;
    }
}
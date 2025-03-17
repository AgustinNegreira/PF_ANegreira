package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class ManejoMaps {
    
    public static HashMap<String, String> quitaValorNulo(HashMap<String, String> map){
        ArrayList<String> valorNulo = new ArrayList();
        for (Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() == null){
                valorNulo.add(entry.getKey());
            }
        }
        for (String key : valorNulo){
            map.remove(key);
        }
        return map;
    }
    
    public static HashMap<String, String> invierteMap(HashMap<String, String> map){
        HashMap<String, String> temp = new HashMap<>();
        for (Entry<String, String> entry : map.entrySet()){
            if (!temp.containsKey(entry.getValue())){
                temp.put(entry.getValue(), entry.getKey());
            }
        }
        return temp;
    }
    
    public static HashMap<String, String> ordenTamEntrada(String rutaArchivo){
        HashMap<String, String> map = new HashMap<>();
        String[] temp = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        String [] aux = new String[2];
        for (int i = 0; i < temp.length; i++) {
            aux = temp[i].split(",");
            map.put(aux[0], aux[1]);
        }
        Set claves = map.keySet();
        List listaClaves = new ArrayList(claves);
        Collections.sort(listaClaves);
        int cant = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaClaves.size(); i++){
            String valor = sorting(listaClaves, cant);
            sb.append(valor);
            cant++;
        }
        System.out.println(sb.toString());
        
        
        return map;
    }
    private static String sorting(List lista, int tamanio){
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < lista.size(); i++){
            String palabra = (String) lista.get(i);
            if (palabra.length() == tamanio){
                aux.append(palabra + "\n");
            }
        }
        return aux.toString();
    }
    
    public static List randomLectura(String argumento, int cantidad){
        String[] temp = ManejadorArchivosGenerico.leerArchivo(argumento);
        List lista = new ArrayList();
        for (String linea : temp){
            lista.add(linea);
        }
        Random rand = new Random();
        for (int i = 0; i < cantidad ; i++){
            int n = rand.nextInt(temp.length-1);
            System.out.println(lista.get(n));
        }
        return lista;
    }
    
    public static HashMap<String, Integer> repeticionPalabras(String rutaArchivo){
        StringBuilder sb = new StringBuilder();
        String texto = Arrays.toString(ManejadorArchivosGenerico.leerArchivo(rutaArchivo));
        texto = texto.trim();
        String delims = "\\W+";
        String[] palabras = texto.split(delims);
        
        HashMap<String, Integer> mapaDeFrecuencias = new HashMap<>();
        for (String palabra : palabras) {
            if (mapaDeFrecuencias.containsKey(palabra)) {
                mapaDeFrecuencias.put(palabra, mapaDeFrecuencias.get(palabra) + 1);
            } else {
                mapaDeFrecuencias.put(palabra, 1);
            }
        }
        /*
        // Imprimir mapa
        for (HashMap.Entry<String, Integer> entry : mapaDeFrecuencias.entrySet()) {
            System.out.printf("Palabra '%s' con frecuencia %d\n", entry.getKey(), entry.getValue());
        }*/
        Map<String, Integer> map = mapaDeFrecuencias;
        System.out.println("After Sorting by value");
        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        Collections.reverse(list);
        for (int i = 0 ; i < 10 ; i++){
            System.out.println(list.get(i));
            
        }
        //list.forEach(System.out::println);
        return mapaDeFrecuencias;
    }
}
package uy.edu.ucu.aed.tdas;
import java.util.LinkedList;
import java.util.List;

public class ManejadorSucursales {

    private static LinkedList<Sucursal> listaSucursales = new LinkedList<Sucursal>();

    // O(1)
    public static void agregarSucursal(Sucursal sucursal){
        listaSucursales.add(sucursal);
    }

    // O(n)
    public static boolean buscarSucursal(String sucursal){
        for( Sucursal suc: listaSucursales){
            if( suc.getCiudad().equals(sucursal))
            {
                return true;
            }
        }
        return false;
    }

    // O(n)
    public static void quitarSucursal(String sucursal){
        Sucursal variable;
        for(Sucursal suc: listaSucursales){
            if(suc.getCiudad().equals(sucursal)){
                variable = suc;
                listaSucursales.remove(suc);
            }
        }
    }

    // O(n)
    public static String listarSucursales(){
        StringBuilder sb = new StringBuilder();
        for(Sucursal suc : listaSucursales){
            sb.append(suc.getCiudad());
            sb.append("\n");
        }
        return sb.toString();
    }

    // O(n)
    public static int indicarCantidadSucursales(){
        int i = 0;
        for(; i < listaSucursales.size() ; i++);
        return i;
    }

    // O(n)
    public static void archivoAListaEnlazada(String[] contenidoArchivo){
        for (String elemento : contenidoArchivo){
            listaSucursales.add(new Sucursal(elemento));
        }
    }

    public static void main(String[] args)
    {
        String[] contenidoArchivo = ManejadorArchivosGenerico.leerArchivo("suc1.txt");
        ManejadorSucursales.archivoAListaEnlazada(contenidoArchivo);
        // System.out.println(ManejadorSucursales.indicarCantidadSucursales());
        System.out.println(ManejadorSucursales.listarSucursales());
        ManejadorSucursales.quitarSucursal("Chicago");
        System.out.println(ManejadorSucursales.listarSucursales());
    }

    /*
    PRUEBA DEL PROGRAMA:

    Pregunta 1:
    Opcion d) 107

    Pregunta 2:
    Opcion c) Shenzen

    Pregunta 3:
    Opcion
     */
}

package org.example;

public class Almacen implements IAlmacen{
    private String direccion;
    private String telefono;
    private final String nombre;
    private Lista listaProductos = new Lista();
    
    public Almacen(String direccion, String telefono, String nombre){
        this.direccion = direccion;
        this.telefono = telefono; 
        this.nombre = nombre;
        insertArr2List();
    }
    
    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista getListaProductos() {
        return listaProductos;
    }
    
    public void insertArr2List(){
        String[] arr = ManejadorArchivosGenerico.leerArchivo(".\\src\\altas.TXT");
        for (int i = 0; i < arr.length ; i++){
            String[] newArr = arr[i].split(",");
            Comparable et = newArr[0];
            String nom = newArr[1];
            int prec = Integer.parseInt(newArr[2]);
            int stock = Integer.parseInt(newArr[3]);
            Producto p = new Producto(et,nom,prec,stock);
            listaProductos.insertar(new Nodo(p.getEtiqueta(), p));
        }
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        listaProductos.insertar(new Nodo(unProducto.getEtiqueta(), unProducto));
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String imprimirSeparador(String separador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Nodo n = listaProductos.buscar(clave);
        int suma = cantidad;
        Producto p = (Producto) n.getDato();
        p.setStock(suma);
        n.setDato(p);
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        Lista prod = this.listaProductos;
        while (prod != null){
            if (prod.getNodo().getEtiqueta().equals(clave)){
                return (Producto) prod.getNodo().getDato();
            }else {
                prod.setPrimero(prod.getNodo().siguiente);
            }
        }
        return null;
    }

    @Override
    public void listarOrdenadoPorNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadProductos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return 
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return 
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (vertices.containsKey(nombreVertice)) {
            vertices.remove(nombreVertice);
            for (TVertice vertice : vertices.values()) {
                vertice.eliminarAdyacencia(nombreVertice);
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }
 
    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    @Override
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if (!existeVertice(unaEtiqueta)) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }


    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }
    
 

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Double[][] floydResult = floyd();
        Double minExcentricity = Double.MAX_VALUE;
        Comparable centro = null;

        for (Comparable vertice : vertices.keySet()) {
            Double excentricidad = (Double) obtenerExcentricidad(vertice);
            if (excentricidad < minExcentricity) {
                minExcentricity = excentricidad;
                centro = vertice;
            }
        }
        return centro;
    }

    @Override
    public Double[][] floyd() {
        Double[][] distancias = UtilGrafos.obtenerMatrizCostos(vertices);
        int size = vertices.size();
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }
        return distancias;    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] floydResult = floyd();
        int idx = getVertices().keySet().stream().toList().indexOf(etiquetaVertice);
        Double excentricidad = Double.MIN_VALUE;

        for (int i = 0; i < floydResult.length; i++) {
            if (floydResult[idx][i] != Double.MAX_VALUE && floydResult[idx][i] > excentricidad) {
                excentricidad = floydResult[idx][i];
            }
        }
        return excentricidad;    }

    @Override
    public boolean[][] warshall() {
        int size = vertices.size();
        boolean[][] alcance = new boolean[size][size];
        int i = 0;
        int j = 0;

        for (TVertice verticeI : vertices.values()) {
            j = 0;
            for (TVertice verticeJ : vertices.values()) {
                alcance[i][j] = verticeI.buscarAdyacencia(verticeJ) != null;
                j++;
            }
            i++;
        }

        for (int k = 0; k < size; k++) {
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {
                    alcance[i][j] = alcance[i][j] || (alcance[i][k] && alcance[k][j]);
                }
            }
        }
        return alcance;

    }

    @Override
    public Collection<TVertice> bpf() {
    }

   
    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
    }


    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
    }

    @Override
    public void desvisitarVertices() {
    }
    
    
}

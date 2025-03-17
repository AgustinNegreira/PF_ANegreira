import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ernesto
 */
public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
        return vertOrigen != null && vertOrigen.eliminarAdyacencia(nomVerticeDestino);
    }

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

    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        return (vertOrigen != null && vertDestino != null) && vertOrigen.buscarAdyacencia(vertDestino) != null;
    }

    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return vertices.get(unaEtiqueta) != null;
    }

    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return vertices.get(unaEtiqueta);
    }

    @Override
    public boolean insertarArista(TArista arista) {
        TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
        TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
        return vertOrigen != null && vertDestino != null && vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
    }

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

    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Double[][] floydResult = floyd();
        Double minExcentricity = Double.MAX_VALUE;
        Comparable centro = null;

        for (Comparable vertice : vertices.keySet()) {
            Double excentricidad = obtenerExcentricidad(vertice);
            if (excentricidad < minExcentricity) {
                minExcentricity = excentricidad;
                centro = vertice;
            }
        }
        return centro;
    }

    @Override
    public Double[][] floyd() {
        int size = vertices.size();
        Double[][] distancias = new Double[size][size];
        int i = 0, j = 0;

        for (TVertice verticeI : vertices.values()) {
            j = 0;
            for (TVertice verticeJ : vertices.values()) {
                if (i == j) {
                    distancias[i][j] = 0.0;
                } else if (verticeI.buscarAdyacencia(verticeJ) != null) {
                    distancias[i][j] = verticeI.buscarAdyacencia(verticeJ).getCosto();
                } else {
                    distancias[i][j] = Double.MAX_VALUE;
                }
                j++;
            }
            i++;
        }

        for (int k = 0; k < size; k++) {
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {
                    if (distancias[i][k] != Double.MAX_VALUE && distancias[k][j] != Double.MAX_VALUE &&
                            distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }
        return distancias;
    }

    @Override
    public Double obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] floydResult = floyd();
        int idx = obtenerIndice(etiquetaVertice);
        Double excentricidad = Double.MIN_VALUE;

        for (int i = 0; i < floydResult.length; i++) {
            if (floydResult[idx][i] != Double.MAX_VALUE && floydResult[idx][i] > excentricidad) {
                excentricidad = floydResult[idx][i];
            }
        }
        return excentricidad;
    }

    @Override
    public boolean[][] warshall() {
        int size = vertices.size();
        boolean[][] alcance = new boolean[size][size];
        int i = 0, j = 0;

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

    public static boolean hayCaminoConWarshall(boolean[][] matrizWarshall, Comparable origen, Comparable destino, Map<Comparable, Integer> indicesVertices) {
        Integer indiceOrigen = indicesVertices.get(origen);
        Integer indiceDestino = indicesVertices.get(destino);
        return (indiceOrigen != null && indiceDestino != null) && matrizWarshall[indiceOrigen][indiceDestino];
    }

    public void desvisitarVertices() {
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    private int obtenerIndice(Comparable etiqueta) {
        int indice = 0;
        for (Comparable key : vertices.keySet()) {
            if (key.equals(etiqueta)) {
                return indice;
            }
            indice++;
        }
        return -1;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        if (vertice == null) {
            throw new IllegalArgumentException("El vértice no debe ser nulo.");
        }
        desvisitarVertices();
        List<TVertice> visitados = new LinkedList<>();
        vertice.bpf(visitados);
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf() {
        desvisitarVertices();
        List<TVertice> recorridos = new ArrayList<>(vertices.size());

        for (TVertice tVertice : vertices.values()) {
            if (!tVertice.getVisitado()) {
                tVertice.bpf(recorridos);
            }
        }
        return recorridos;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        TVertice origen = buscarVertice(etiquetaOrigen);
        if (origen == null) {
            return null;
        }
        return bpf(origen);
    }

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        TVertice verticeOrigen = buscarVertice(etiquetaOrigen);
        if (verticeOrigen != null) {
            verticeOrigen.todosLosCaminos(etiquetaDestino, new TCamino(verticeOrigen), todosLosCaminos);
        }
        return todosLosCaminos;
    }
}
package org.example;

import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        TGrafoNoDirigido arbolPrim = new TGrafoNoDirigido(this.getVertices().values(), new LinkedList<>());
        double costoTotal = 0.0d;

        if (this.getVertices().isEmpty()) {
            return arbolPrim;
        }

        TAristas aristas = this.getLasAristas();
        LinkedList<Comparable> vertices = new LinkedList<>();
        for (TVertice vertice : this.getVertices().values()) {
            vertices.add(vertice.getEtiqueta());
        }

        Collection<Comparable> U = new LinkedList<>();

        U.add(vertices.removeFirst());
        while (!vertices.isEmpty()) {
            TArista a = aristas.buscarMin(U, vertices);
            TVertice v = this.getVertices().get(a.getEtiquetaDestino());
            vertices.remove(v.getEtiqueta());
            U.add(v.getEtiqueta());
            arbolPrim.insertarArista(a);
            costoTotal += a.getCosto();
        }
        System.out.println(costoTotal);
        return arbolPrim;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
               LinkedList<TArista> aristasKruskal = new LinkedList(); //Aqui se almacenaran las aristas seleccionadas.
        Map<Comparable, TVertice> vertices = getVertices();

        if (!vertices.isEmpty()) {
            desvisitarVertices();
            HashMap<Comparable, LinkedList<TVertice>> colecciones = new HashMap(vertices.size());
            LinkedList<TVertice> colTemp;

            //Creamos una "coleccion" para cada arista
            for (TVertice v : vertices.values()) {
                colTemp = new LinkedList();
                colTemp.add(v);
                colecciones.put(v.getEtiqueta(), colTemp);
            }

            //Ordenamos todas las aristas del grafo de menor costo a mayor
            LinkedList<TArista> aristasOrdenadas = new LinkedList();
            forAristas:
            for (TArista a : lasAristas) {
                if (aristasOrdenadas.isEmpty() || aristasOrdenadas.getFirst().getCosto() > a.getCosto()) {
                    aristasOrdenadas.addFirst(a);
                    continue;
                }
                for (int i = 1; i < aristasOrdenadas.size(); i++) {
                    if (aristasOrdenadas.get(i).getCosto() > a.getCosto()) {
                        aristasOrdenadas.add(i - 1, a);
                        continue forAristas;
                    }
                }
                aristasOrdenadas.add(a);
            }

            //Conectamos las colecciones de vertices (no conectados) mediante la arista de menor costo posible
            TArista menorArista;
            LinkedList<TVertice> colOrigen, colDestino;
            while (!aristasOrdenadas.isEmpty()) {
                menorArista = aristasOrdenadas.pollFirst();
                colOrigen = colecciones.get(menorArista.etiquetaOrigen);
                colDestino = colecciones.get(menorArista.etiquetaDestino);
                if (colOrigen != colDestino) {
                    colOrigen.addAll(colDestino);
                    for (TVertice v : colDestino) {
                        if (colecciones.get(v.getEtiqueta()) != colOrigen) {
                            colecciones.replace(v.getEtiqueta(), colOrigen);
                        }
                    }
                    aristasKruskal.add(menorArista);
                }
            }
        }

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices.values(), aristasKruskal);
        return grafo;
    }

    @Override
    public Collection<TVertice> bea() {
        // Colección para almacenar el recorrido en anchura.
        Collection<TVertice> visitados = new LinkedList<>();

        // Si no hay vértices en el grafo, retornamos la colección vacía.
        if (this.getVertices().isEmpty()) {
            return visitados;
        }

        // Desvisitar todos los vértices para asegurar que el grafo esté en estado inicial.
        this.desvisitarVertices();

        // Iniciamos el BEA desde cada componente conexa del grafo.
        for (TVertice vertice : this.getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(visitados);
            }
        }

        return visitados;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
         if (this.getVertices().isEmpty()) {
            return null;
        } else {
            this.desvisitarVertices();
            if(this.existeVertice(etiquetaOrigen))
            {
                TVertice vert= super.buscarVertice(etiquetaOrigen);
                Collection<TVertice> verts = new LinkedList<TVertice>();
                vert.bea(verts);
                return verts;
            }
            return null;
        }
    }

    @Override
    public boolean esConexo() {
        desvisitarVertices();
        List<TVertice> result = new LinkedList<>();
        int i = 0;
        for (TVertice v : getVertices().values()) {
            if (!v.getVisitado()) {
                v.bea(result);
                i++;
                if (i > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean conectados(TVertice origen, TVertice destino) {
        if (buscarVertice(origen.getEtiqueta()) != null && buscarVertice(destino.getEtiqueta()) != null) {
            desvisitarVertices();
            origen.conectadoCon(destino);
        }
        return false;
    }

    public double getCostoTotal(){
        double costo = 0;
        for (TArista tArista : lasAristas) {
            costo += tArista.getCosto();
        }
        return costo/2;
    }

    public TAristas UcuRedes(){
        TGrafoNoDirigido arbolCostoMinimo = new TGrafoNoDirigido(vertices.values(),new TAristas());
        TAristas ucuRedes = new TAristas();
        TAristas aristasOrdenadas = lasAristas.copiarTAristasOrdenado();
        int aristasAgregadas = 0;

        while (aristasAgregadas != getVertices().size() - 1){
            TArista aristaMin = aristasOrdenadas.removeFirst();
            TVertice verticeOrigen = arbolCostoMinimo.buscarVertice(aristaMin.getEtiquetaOrigen());
            TVertice verticeDestino = arbolCostoMinimo.buscarVertice(aristaMin.getEtiquetaDestino());
            if (!arbolCostoMinimo.conectados(verticeOrigen, verticeDestino)){
                arbolCostoMinimo.insertarArista(aristaMin);
                arbolCostoMinimo.getLasAristas().add(aristaMin);
                arbolCostoMinimo.getLasAristas().add(aristaMin.aristaInversa());
                aristasAgregadas++;
                ucuRedes.add(aristaMin);
            }
        }
        return ucuRedes;
    }
}
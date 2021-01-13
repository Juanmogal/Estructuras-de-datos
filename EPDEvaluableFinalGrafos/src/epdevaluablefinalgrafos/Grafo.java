/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epdevaluablefinalgrafos;

import java.util.*;

/**
 *
* @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public class Grafo<E> implements IGrafo {

    private LinkedList<Object> listaVertices; // creamos una lista de vertices
    private int numVertices;

    public Grafo() {
        this.listaVertices = new LinkedList<Object>();
        this.numVertices = 0;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public LinkedList<Object> getListaVertices() {
        return listaVertices;
    }

    public void anadirVertice(int idVertice) {
        this.listaVertices.addFront(idVertice);
    }

    public boolean areAdjacent(Vertice v, Vertice w) { 
        boolean adyacentes = false;
        Vertice aux = (Vertice) listaVertices.getElement(0);
        for (int i = 1; i <= listaVertices.size(); i++) {
            Edge eaux = (Edge) aux.getlistaDeAdyacentes().getElement(0);
            if (v.getId() == aux.getId()) {
                int j = 1;
                while (eaux != null) {
                    if (w.getId() == aux.getId()) {
                        return true;
                    }
                    eaux = (Edge) aux.getlistaDeAdyacentes().getElement(j);
                    j++;
                }
            }
            aux = (Vertice) listaVertices.getElement(i);
        }
        return adyacentes;
    }

    public boolean replace(int idVertice, int x) {
        boolean reemplazado = false;

        int posicionReemplazar = listaVertices.indexOf(idVertice, listaVertices);
        Vertice aux = (Vertice) listaVertices.getElement(posicionReemplazar);
        aux.setId(x);

        return reemplazado;
    }

    public boolean replace(Edge e, Object x) {
        boolean reemplazado = false;
        Vertice aux = (Vertice) listaVertices.getElement(0);
        for (int i = 1; i <= listaVertices.size(); i++) {
            Edge eaux = (Edge) aux.getlistaDeAdyacentes().getElement(0);
            int j = 1;
            while (eaux != null) {
                if (e.getId() == eaux.getId()) {
                    eaux.setId(x);
                }
                eaux = (Edge) aux.getlistaDeAdyacentes().getElement(j);
                j++;
            }
            aux = (Vertice) listaVertices.getElement(i);
        }

        return reemplazado;
    }

    public boolean insertVertex(int o) {
        boolean anadido = false;
        listaVertices.addEnd(o);
        this.numVertices++;
        anadido = true;

        return anadido;
    }

    public Vertice find(Integer idVertice) { // recorremos la lista de vertices y vamos buscando el vertice con el id que le pasemos por parametro.
        //cuando lo encuentre lo devolverá

        for (int i = 0; i < listaVertices.size(); i++) {
            if (listaVertices.getElement(i) == idVertice) {
                return listaVertices.get(i);
            }
        }
        return (null);
    }

    public boolean insertEdge(int idVertice, int idArista) {
        boolean insertado = false;
        Vertice aux = null;

        Vertice vaux = find(idVertice); // Buscamos el vertice cuyo id le hemos pasado por parametro

        vaux.getlistaDeAdyacentes().addEnd(idArista); // añadimos al final de la lista de adyacencias de este vertice una con idArista(pasado por parametro)

        return insertado;
    }

    public boolean removeVertex(int idVertice) { 
        boolean borrado = false;

        int indice = listaVertices.indexOf(idVertice, listaVertices); // guardamos en indice, el indice que ocupa el vertice cuyo id le hemos pasado pro parametro, en la
        //lista de vertices, posteriormente lo elimianmos con remove
        listaVertices.remove(indice);

        return borrado;
    }

    public boolean removeEdge(int idEdge) {
        boolean borrado = false;
        Vertice aux = null;

        for (int i = 0; i < listaVertices.size(); i++) {
            aux = (Vertice) listaVertices.getElement(i);
            int IndiceBorrar = 0;
            IndiceBorrar = aux.getlistaDeAdyacentes().indexOf(idEdge, aux.getlistaDeAdyacentes());
            aux.getlistaDeAdyacentes().remove(IndiceBorrar);
            borrado = true;
        }

        return borrado;
    }

    public Iterator vertices() {
        ArrayList<Object> vertices = new ArrayList<>(); // creamos una lista de objetos que seran tipo vertice
        Vertice aux = listaVertices.getPrimerNodo(); // nos situamos en el primer nodo
        for (int i = 1; i <= numVertices; i++) { //lo haremos tantas veces como numero de vertices tengamos
            vertices.add(aux); // vamos añadiendo a la lista de vertices creada anteriormente
            aux = aux.getNext(); // en aux, guardamos el siguiente a aux para la siguiente iteracion
        }
        return vertices.iterator();
    }

    public Iterator edgeArista(int IDVertice) { //Metodo implementado y usado para DFS
        ArrayList<Vertice> edgesDeUnVertice = new ArrayList<>();
        Vertice aux = listaVertices.find(IDVertice);
        Vertice eaux = aux.getlistaDeAdyacentes().getPrimerNodo();
        while (eaux != null) {
            edgesDeUnVertice.add(eaux);
            eaux = eaux.getNext();
        }

        return edgesDeUnVertice.iterator();
    }

    public Iterator edges() {
        ArrayList<Vertice> edges = new ArrayList<>();
        Vertice aux = listaVertices.getPrimerNodo();
        for (int i = 1; i <= numVertices; i++) {
            Vertice eaux = aux.getlistaDeAdyacentes().getPrimerNodo();
            while (eaux != null) {
                edges.add(eaux);
                eaux = eaux.getNext();
            }
            aux = aux.getNext();
        }
        return edges.iterator();
    }

    public Vertice getVertice(int idVertice) { // devolveremos el vertice de la lista de vertices cuyo id coincide con el pasado pro parametro
        return listaVertices.find(idVertice);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epdevaluablefinalgrafos;

/**
 *
 * @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public class Laberinto<E> {

    private Grafo grafo;
    private Stack control;

    public Laberinto(Grafo grafo) {
        this.grafo = grafo;
        this.control = new Stack();
    }

    public boolean insertVertex(int o) {
        return this.grafo.insertVertex(o);
    }

    public boolean insertEdge(int v, int o) {
        return this.grafo.insertEdge(v, o);
    }
//

    public boolean removeVertex(int idVertice) {
        return this.grafo.removeVertex(idVertice);
    }

    public boolean removeEdge(int idEdge) {
        return this.grafo.removeEdge(idEdge);
    }

    public void DFS(Vertice vInicio, Vertice vFin) {
        Stack pila_DFS = new Stack();
        boolean caminoEncontrado = false;
        pila_DFS.push(vInicio); // introducimos en la pila la ciudad de inicio
        vInicio.setVisited(true);//marcamos que ya esta visitada
        while (!pila_DFS.isEmpty() && !caminoEncontrado) {
            Vertice verticeAnterior = pila_DFS.pop();
            System.out.print(verticeAnterior.getId() + "->"); // imprimimos la ultima ciudad visitada

            LinkedList<Vertice> adyacentesVerticeActual = verticeAnterior.getlistaDeAdyacentes(); // guardamos en una lista los adyacentes del nodo actual
            if (adyacentesVerticeActual != null) { // si tiene adyacentes
                for (int i = 0; i < adyacentesVerticeActual.size(); i++) {
                    Vertice vaux = adyacentesVerticeActual.get(i);
                    Vertice vaux2 = grafo.getListaVertices().find(vaux.getId()); // buscamos en la lista de vertice el vertice cuyo id tiene vaux para tener todos los datos de el
                    if (vaux2 != null && !vaux2.isVisited()) { // si la ciudad actual no esta visitada y es distinta de null la metemos en la pila
                        pila_DFS.push(vaux2);
                        vaux2.setVisited(true); // marcamos la ciudad actual como visitada
                        if (vaux2 == vFin) { // si la ciudad actual 
                            caminoEncontrado = true;
                            System.out.print(vaux2.getId()+"\n");
                        }
                    }
                }
            }

        }
    }
}

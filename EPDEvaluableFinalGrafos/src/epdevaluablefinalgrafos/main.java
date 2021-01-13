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
public class main {

    public static void main(String[] args) {
        Grafo g = new Grafo();
        Laberinto lab = new Laberinto(g);

        /*insertVertex(int vertice)*/
        lab.insertVertex(0);
        lab.insertVertex(1);
        lab.insertVertex(2);
        lab.insertVertex(3);
        lab.insertVertex(4);
        lab.insertVertex(5);
        lab.insertVertex(6);
        lab.insertVertex(7);
        lab.insertVertex(8);
        lab.insertVertex(9);
        lab.insertVertex(10);
        lab.insertVertex(11);
        lab.insertVertex(12);
        lab.insertVertex(13);
        lab.insertVertex(14);

        /*insertEdge(int vertice, int arista)*/
        lab.insertEdge(0, 1);
        lab.insertEdge(1, 0);
        lab.insertEdge(1, 2);
        lab.insertEdge(1, 5);
        lab.insertEdge(2, 1);
        lab.insertEdge(2, 3);
        lab.insertEdge(2, 6);
        lab.insertEdge(3, 2);
        lab.insertEdge(6, 2);
        lab.insertEdge(4, 5);
        lab.insertEdge(4, 7);
        lab.insertEdge(5, 4);
        lab.insertEdge(5, 8);
        lab.insertEdge(7, 8);
        lab.insertEdge(7, 11);
        lab.insertEdge(8, 5);
        lab.insertEdge(8, 7);
        lab.insertEdge(8, 9);
        lab.insertEdge(9, 8);
        lab.insertEdge(9, 12);
        lab.insertEdge(9, 10);
        lab.insertEdge(10, 9);
        lab.insertEdge(10, 13);
        lab.insertEdge(11, 7);
        lab.insertEdge(12, 9);
        lab.insertEdge(13, 11);
        lab.insertEdge(13, 14);

        //Llamamos al metodo DFS pasándole por parámetro LOS VERTICES 0 y 14, para ello usaremos el método getVertice(idVertice) que devuelve
        //el vértice cuyo id le pasamos por parámetro
        System.out.println("Algoritmo búsqueda en profundidad: ");
        lab.DFS(g.getVertice(0), g.getVertice(14));

    }

}

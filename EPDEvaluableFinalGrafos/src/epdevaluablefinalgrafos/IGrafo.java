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
public interface IGrafo {

    public interface Graph {

        public boolean areAdjacent(Vertice v, Vertice w);

        public boolean replace(Vertice v, Object x);

        public boolean replace(Edge e, Object x);

        public boolean insertVertex(Object o);

        public boolean insertEdge(Vertice v, Vertice w, Object o);

        public boolean removeVertex(Vertice v);

        public boolean removeEdge(Edge e);

        public Iterator vertices();

        public Iterator edges();
    }
}

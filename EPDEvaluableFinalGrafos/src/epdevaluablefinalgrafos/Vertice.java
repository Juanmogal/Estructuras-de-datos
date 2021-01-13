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
import java.util.*;

public class Vertice<E> {

    private int id;
    private boolean visited;
    private Vertice next;
    private LinkedList<Vertice> listaDeAdyacentes;

    public Vertice(int id) {
        this.id = id;
        this.listaDeAdyacentes = new LinkedList();
    }

    public Vertice() {
        this.listaDeAdyacentes = new LinkedList();
    }

    public void addAdyacente(Vertice v) {
        this.listaDeAdyacentes.addEnd(v.getId());
    }

    public LinkedList<Vertice> getlistaDeAdyacentes() {
        return listaDeAdyacentes;
    }

    public int getId() {
        return id;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertice getNext() {
        return next;
    }

    public void setNext(Vertice next) {
        this.next = next;
    }

}

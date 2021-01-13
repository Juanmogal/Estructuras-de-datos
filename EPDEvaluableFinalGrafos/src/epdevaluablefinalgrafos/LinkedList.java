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

public class LinkedList<E> implements ILinkedList<Object> {

    private Vertice primerNodo;
    private Vertice ultimoNodo;
    private int size;

    public LinkedList() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.size = 0;
    }

    public Vertice getPrimerNodo() {
        return primerNodo;
    }

    public void add(int newElement, int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("indice incorrecto");
        } else {

            if (index == 0) {
                addFront(newElement);
            } else if (index == size) {
                addEnd(newElement);
            } else {
                Vertice newNode = new Vertice();
                newNode.setId(newElement);
                Vertice aux = primerNodo;
                for (int i = 1; i < index; i++) {
                    aux = aux.getNext();
                }
                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
                this.size++;
            }

        }
    }

    public void addEnd(int newElement) {

        if (primerNodo == null) {
            addFront(newElement);
        } else {
            Vertice newNode = new Vertice();
            newNode.setId(newElement);
            ultimoNodo.setNext(newNode);
            ultimoNodo = newNode;
            //newNode.setNext(null); //esta inicializado a null en el constructor, por eso es innecesario
            this.size++;
        }

    }

    public void addFront(int newElement) {

        Vertice newNode = new Vertice();
        newNode.setId(newElement);
        if (primerNodo != null) {
            newNode.setNext(primerNodo);
            primerNodo = newNode;
        } else {
            newNode.setNext(null);
            primerNodo = newNode;
            ultimoNodo = newNode;
        }
        this.size++;

    }

    public Object getElement(int index) throws IndexOutOfBoundsException {
        Object elemento = null;
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index incorrecto");
        } else {
            if (index == 0) {
                elemento = primerNodo.getId();
            } else if (index == size - 1) {
                elemento = ultimoNodo.getId();
            } else {
                Vertice aux = primerNodo;
                for (int i = 1; i <= index; i++) {
                    aux = aux.getNext();
                }
                elemento = aux.getId();
            }

        }
        return elemento;
    }

    public Vertice get(int index) throws IndexOutOfBoundsException {
        Vertice elemento = null;
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index incorrecto");
        } else {
            Vertice aux = primerNodo;
            for (int i = 1; i <= index; i++) {
                aux = aux.getNext();
            }
            elemento = aux;

        }
        return elemento;
    }

    @Override
    public boolean isEmpty() {
        boolean vacio = true;
        if (primerNodo != null) {
            vacio = false;
        }
        return vacio;

    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index incorrecto");
        }
        if (index == 0) {
            removeFront();
        } else if (index == size - 1) {
            removeEnd();
        } else {
            Vertice aux1 = primerNodo;
            Vertice aux2 = primerNodo;
            for (int i = 1; i < index + 1; i++) {
                aux1 = aux1.getNext();
            }
            for (int i = 1; i < index; i++) {
                aux2 = aux2.getNext();
            }
            aux2.setNext(aux1.getNext());
            aux1.setNext(null);
            this.size--;
        }

    }

    public void removeEnd() {
        Vertice aux = primerNodo;
        for (int i = 1; i < size - 1; i++) {
            aux = aux.getNext();
        }
        aux.setNext(null);
        ultimoNodo = aux;
        this.size--;
    }

    public void removeFront() {
        Vertice aux = primerNodo;
        aux = primerNodo.getNext();
        primerNodo.setNext(null);
        primerNodo = aux;
        this.size--;
    }

    public int size() {
        return size;
    }

    public Vertice find(int ID) { //usado para el metodo de busqueda y los iteradores
        Vertice vaux = this.primerNodo;
        for (int i = 0; i < this.size; i++) {
            Vertice v = new Vertice(ID);
            if (vaux.getId() == v.getId()) {
                return vaux;
            }
            vaux = vaux.getNext();
        }
        return (null);
    }
//    public Node find(Object x) {
//        Node current =  primerNodo; // Initialize current  
//        while (current != null) {
//            if (current.getId() == x) {
//                return current;
//            }
//            current = current.getNext();
//        }
//        return (null);
//    }

    public int indexOf(Object id, LinkedList lista) {
        int indice = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.getElement(i).equals(id)) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    @Override
    public String toString() {
        Vertice aux = this.primerNodo;
        String cadena = "Lista:\n" + aux.getId() + "\n";
        while (aux.getNext() != null) {
            aux = aux.getNext();
            cadena += aux.getId() + "\n";
        }
        return cadena;
    }

}

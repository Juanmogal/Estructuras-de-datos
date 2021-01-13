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
public interface ILinkedList<Object> {

        //añade un elemento en posición index, desplaza los siguientes

        void add(int newElement, int index) throws IndexOutOfBoundsException;
        //añade un elemento al final

        void addEnd(int newElement);
        //añade un elemento al principio

        void addFront(int newElement);
        //devuelve el elemento en posición index

        Object getElement(int index) throws IndexOutOfBoundsException;

        boolean isEmpty();
        //borra elemento en posición index

        void remove(int index) throws IndexOutOfBoundsException;
        //borra último elemento

        void removeEnd();
        //borra primer elemento

        void removeFront();

        int size();

        String toString();
    }


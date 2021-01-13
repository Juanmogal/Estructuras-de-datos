/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epdevaluablefinalgrafos;

import java.util.EmptyStackException;

/**
 *
* @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public class Stack implements IStack {

    private int size;
    private Vertice[] ArrayStack;

    public Stack() {
        this.size = 0;
        this.ArrayStack = new Vertice[100];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Vertice top() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return ArrayStack[size - 1];
        }
    }

    @Override
    public void push(Vertice element){
            ArrayStack[size] = element;
            this.size++;
        }
    

    @Override
    public Vertice pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            Vertice aux = ArrayStack[size - 1];
            ArrayStack[size-1] = null;
            size --;
            return aux;
        }
    }
    
    //he sobrescrito el metodo toString para compprobar si todo va bien
    @Override
    public String toString() {
        String cadena=" ";
        for(int i=size -1;i>=0;i--){
            cadena += ArrayStack[i] + "\n";
        }
        return cadena;
    }
    

}

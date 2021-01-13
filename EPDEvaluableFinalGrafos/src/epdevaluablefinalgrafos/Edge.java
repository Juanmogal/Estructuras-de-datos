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
public class Edge<E> {
    
    private Object id;
    

    public Edge(Object id) {
        this.id = id;
        
    }
    
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    
    
    
}

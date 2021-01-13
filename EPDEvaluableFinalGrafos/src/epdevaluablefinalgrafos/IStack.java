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

public interface IStack  {

/**

* Return the number of elements in the stack.

*

* @return number of elements in the stack.

*/

public int size();

/**

* Return whether the stack is empty.

*

* @return true if the stack is empty, false otherwise.

*/

public boolean isEmpty();

/**

* Inspect the element at the top of the stack.

*

* @return top element in the stack.

* @exception EmptyStackException if the stack is empty.

*/

public Vertice top() throws EmptyStackException;

/**

* Insert an element at the top of the stack.

*

* @param element to be inserted.

*/

public void push(Vertice element);

/**

* Remove the top element from the stack.

*

* @return element removed.

* @exception EmptyStackException if the stack is empty.

*/

public Vertice pop() throws EmptyStackException;

}
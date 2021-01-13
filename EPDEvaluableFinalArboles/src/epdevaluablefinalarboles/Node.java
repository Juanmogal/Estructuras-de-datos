package epdevaluablefinalarboles;
/**
 *
* @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public class Node<E> {
    
    private E elemento;
    private Node<E> next;

    public Node() {
        this.elemento = null;
        this.next = null;
    }

    
    
    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    public String toString(){
        return "\t" + this.elemento + "\n";
    }
    
    
    
}

package epdevaluablefinalarboles;

/**
 *
* @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public class LinkedList<E> implements ILinkedList<E> {

    private Node<E> primerNodo;
    private Node<E> ultimoNodo;
    private int size;

    public LinkedList() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.size = 0;
    }
    @Override
    public void add(E newElement, int index) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("indice incorrecto");
        } else {
            if (newElement != null) {
                if (index == 0) {
                    addFront(newElement);
                } else if (index == size) {
                    addEnd(newElement);
                } else {
                    Node<E> newNode = new Node<E>();
                    newNode.setElemento(newElement);
                    Node<E> aux = primerNodo;
                    for (int i = 1; i < index; i++) {
                        aux = aux.getNext();
                    }
                    newNode.setNext(aux.getNext());
                    aux.setNext(newNode);
                    this.size++;
                }
            }

        }
    }

    @Override
    public boolean addEnd(E newElement) {
        boolean anadido = true;
        if (newElement != null) {
            if (primerNodo == null) {
                addFront(newElement);
                anadido = true;
            } else {
                Node<E> newNode = new Node<E>();
                newNode.setElemento(newElement);
                ultimoNodo.setNext(newNode);
                ultimoNodo = newNode;
                //newNode.setNext(null); //esta inicializado a null en el constructor, por eso es innecesario
                this.size++;
                anadido = true;
            }
        }
        return anadido;
    }

    @Override
    public void addFront(E newElement) {
        if (newElement != null) {
            Node<E> newNode = new Node<E>();
            newNode.setElemento(newElement);
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
    }

    @Override
    public E getElement(int index) throws IndexOutOfBoundsException {
        E elemento = null;
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index incorrecto");
        } else {
            if (index == 0) {
                elemento = primerNodo.getElemento();
            } else if (index == size - 1) {
                elemento = ultimoNodo.getElemento();
            } else {
                Node<E> aux = primerNodo;
                for (int i = 1; i <= index; i++) {
                    aux = aux.getNext();
                }
                elemento = aux.getElemento();
            }

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

    @Override
    //TERMINAR METODO
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index incorrecto");
        }
        if (index == 0) {
            removeFront();
        } else if (index == size - 1) {
            removeEnd();
        } else {
            Node<E> aux1 = primerNodo;
            Node<E> aux2 = primerNodo;
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

    @Override
    public void removeEnd() {
        Node<E> aux = primerNodo;
        for (int i = 1; i < size-1; i++) {
            aux = aux.getNext();
        }
        aux.setNext(null);
        ultimoNodo = aux;
        this.size--;
    }

    @Override
    public void removeFront() {
        Node<E> aux = primerNodo;
        aux = primerNodo.getNext();
        primerNodo.setNext(null);
        primerNodo = aux;
        this.size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> aux = this.primerNodo;
        String cadena="Lista:\n"+aux.getElemento()+"\n";
        while(aux.getNext() != null){
            aux = aux.getNext();
            cadena+= aux.getElemento()+"\n";
        }
        return cadena;
    }

    
}

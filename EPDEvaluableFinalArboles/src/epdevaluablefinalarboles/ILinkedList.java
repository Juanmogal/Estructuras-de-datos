package epdevaluablefinalarboles;
/**
 *
 * @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public interface ILinkedList<E> {

        //añade un elemento en posición index, desplaza los siguientes

        void add(E newElement, int index) throws IndexOutOfBoundsException;
        //añade un elemento al final

        boolean addEnd(E newElement);
        //añade un elemento al principio

        void addFront(E newElement);
        //devuelve el elemento en posición index

        E getElement(int index) throws IndexOutOfBoundsException;

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


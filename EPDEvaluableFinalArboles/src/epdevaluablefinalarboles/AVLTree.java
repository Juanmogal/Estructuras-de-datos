package epdevaluablefinalarboles;

/**
 *
 * @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */

public class AVLTree {

    private int size;
    private BinaryNode root; //nodo que apunta a la raiz del arbol

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public int getAltura(BinaryNode node) { // 
        int altura = -1; // devolverá -1 si el nodo es null. Si el nodo no es nulo devolverá el getAltura de ese nodo.
        if (node != null) {
            altura = node.getAltura();
        }
        return altura;
    }

    //llamaremos a este metodo cada vez que se modifique la altura del arbol
    public void actualizarAltura(BinaryNode node) {
        node.setAltura(1 + Math.max(this.getAltura(node.getHijoIzquierdo()), this.getAltura(node.getHijoDerecho())));
    }

    //metodo para sacar el padre de un nodo
    public BinaryNode getPadre(BinaryNode nodo) {
        BinaryNode aux = null;
        BinaryNode aux2 = root;
        while ((nodo.getElemento().compareTo(aux2.getElemento()) != 0)) {
            if (nodo.getElemento().compareTo(aux2.getElemento()) < 0) {
                aux = aux2;
                aux2 = aux.getHijoIzquierdo();
            } else if (nodo.getElemento().compareTo(aux2.getElemento()) > 0) {
                aux = aux2;
                aux2 = aux.getHijoDerecho();
            }
        }

        return aux;
    }

    public int getFactorEquilibrio(BinaryNode node) {
        return ((node == null) ? 0 : this.getAltura(node.getHijoDerecho()) - this.getAltura(node.getHijoIzquierdo()));
    }

    //realizará una rotacion a la derecha y devolverá nuestro nueva raiz
    public BinaryNode rotacionDerecha(BinaryNode node) {
        BinaryNode aux = node.getHijoIzquierdo();
        BinaryNode aux2 = aux.getHijoDerecho();
        aux.setHijoDerecho(node);
        node.setHijoIzquierdo(aux2);
        this.actualizarAltura(node);
        this.actualizarAltura(aux);
        return (aux);
    }

    //realizará una rotacion a la izquierda y devolverá nuestro nueva raiz
    public BinaryNode rotacionIzquierda(BinaryNode node) {
        BinaryNode aux = node.getHijoDerecho();
        BinaryNode aux2 = aux.getHijoIzquierdo();
        aux.setHijoIzquierdo(node);
        node.setHijoDerecho(aux2);
        this.actualizarAltura(node);
        this.actualizarAltura(aux);
        return (aux);
    }

    private BinaryNode rebalance(BinaryNode node) {
        actualizarAltura(node);
        int balance = getFactorEquilibrio(node);
        /*el factor de equilibrio debe estar entre -1 y 1*/
        if (balance > 1) {
            if (this.getAltura(node.getHijoDerecho().getHijoDerecho()) > this.getAltura(node.getHijoDerecho().getHijoIzquierdo())) {
                node = rotacionIzquierda(node); 
            } else {
                node.setHijoDerecho(rotacionDerecha(node.getHijoDerecho()));
                node = rotacionIzquierda(node);
            }
        } else if (balance < -1) {
            if (this.getAltura(node.getHijoIzquierdo().getHijoIzquierdo()) > this.getAltura(node.getHijoIzquierdo().getHijoDerecho())) {
                node = this.rotacionDerecha(node);
            } else {
                node.setHijoIzquierdo(this.rotacionIzquierda(node.getHijoIzquierdo()));
                node = this.rotacionDerecha(node);
            }
        }
        return (node);
    }

   
    public void anadirElemento(Comparable hashtag) {
        this.root = this.helperAnadirElemento(this.root, hashtag);
    }

    //le pasamos el nodo raiz para añadir y el elemento que este tendrá, es decir, el hashtag
    private BinaryNode helperAnadirElemento(BinaryNode nodeRaiz, Comparable hashtag) {
        if (nodeRaiz == null) {
            this.size++;
            return (new BinaryNode(hashtag));
        } else if (nodeRaiz.getElemento().compareTo(hashtag) < 0) {// si el hashtag del nodo raiz actual es alfabéticamente menor que el que le pasamos por parametro
            nodeRaiz.setHijoDerecho(helperAnadirElemento(nodeRaiz.getHijoDerecho(), hashtag));
        } else if (nodeRaiz.getElemento().compareTo(hashtag) > 0) {// si el hashtag del nodo raiz actual es alfabéticamente mayor que el que le pasamos por parametro
            nodeRaiz.setHijoIzquierdo(helperAnadirElemento(nodeRaiz.getHijoIzquierdo(), hashtag));
        } else if (nodeRaiz.getElemento().compareTo(hashtag) == 0) { // si son iguales
            System.out.println("El hashtag " + hashtag + " está repetido.");
        }
        return rebalance(nodeRaiz);
    }

    public void borrarElemento(Comparable hashtag) {
        this.root = (this.helperBorrarElemento(this.root, hashtag));
    }

    //le pasamos el nodo raiz para borrar un elemento y el elemento que este tendrá, es decir, el hashtag
    private BinaryNode helperBorrarElemento(BinaryNode nodoRaiz, Comparable hashtag) {
        if (nodoRaiz == null) {
            this.size--;
            return nodoRaiz;
        } else if (nodoRaiz.getElemento().compareTo(hashtag) < 0) { // si el hashtag del nodo raiz actual es alfabéticamente menor que el que le pasamos por parametro
            nodoRaiz.setHijoDerecho(helperBorrarElemento(nodoRaiz.getHijoDerecho(), hashtag));
        } else if (nodoRaiz.getElemento().compareTo(hashtag) > 0) { // si el hashtag del nodo raiz actual es alfabéticamente mayor que el que le pasamos por parametro
            nodoRaiz.setHijoIzquierdo(helperBorrarElemento(nodoRaiz.getHijoIzquierdo(), hashtag));
        } else {
            if (nodoRaiz.getHijoIzquierdo() == null || nodoRaiz.getHijoDerecho() == null) { // si son iguales y alguno de los dos es null
                if (nodoRaiz.getHijoIzquierdo() == null) {
                    nodoRaiz = nodoRaiz.getHijoDerecho();
                } else {
                    nodoRaiz = nodoRaiz.getHijoIzquierdo();
                }
            } else {
                BinaryNode aux = this.hijoMasLejano(nodoRaiz.getHijoDerecho());
                nodoRaiz.setElemento(aux.getElemento());
                nodoRaiz.setHijoDerecho(helperBorrarElemento(nodoRaiz.getHijoDerecho(), nodoRaiz.getElemento()));
            }
        }
        if (nodoRaiz != null) {
            nodoRaiz = rebalance(nodoRaiz); // si es necesario equilibriraremos el arbol
        }
        return nodoRaiz;
    }

    private BinaryNode hijoMasLejano(BinaryNode node) { //nos quedamos con el hijo izquierdo que esté mas abajo en el árbol, que necesitará al borrar un nodo
        BinaryNode actual = node;
        while (actual.getHijoIzquierdo() != null) {
            actual = actual.getHijoIzquierdo();
        }
        return actual;
    }

    public BinaryNode find(Comparable hashtag) { //recorre el arbol buscando un nodo que tenga el mismo hashtag que le pasamso por parametro y devuelve dicho nodo
        BinaryNode current = this.root;
        boolean exito = false;
        while (current != null && !exito) {
            if (current.getElemento().compareTo(hashtag) == 0) { 
                exito = true;
            } else {
                if (current.getElemento().compareTo(hashtag) < 0) { 
                    current = current.getHijoDerecho();
                } else {
                    current = current.getHijoIzquierdo();
                }
            }

        }
        return current;
    }

    public String toString() { // con este metodo sacaremos padre y sus dos hijos, para sacar los hijos de esos hijos llamaremos a level order
        String Cadena = "";
        if (root != null) {
            Cadena += root.toStringElemento(); // imprimo el tostring solo del elemento
            Cadena += "Padre: " + getPadre(root) + "\n";
            Cadena += root.toStringHijos() + "Factor equilibrio : " + getFactorEquilibrio(root.getHijoIzquierdo()) + "\n"; //imprimo el tostring de los hijos
            Cadena += "\n";

            if (root.getHijoIzquierdo() != null) {
                Cadena += root.getHijoIzquierdo().toStringElemento();
                Cadena += "Padre: " + getPadre(root.getHijoIzquierdo()).toStringElemento();
                Cadena += root.getHijoIzquierdo().toStringHijos() + "Factor equilibrio : " + getFactorEquilibrio(root.getHijoIzquierdo()) + "\n\n";
            }
            if (root.getHijoDerecho() != null) {
                Cadena += root.getHijoDerecho().toStringElemento();
                Cadena += "Padre: " + getPadre(root.getHijoDerecho()).toStringElemento();
                Cadena += root.getHijoDerecho().toStringHijos() + "Factor equilibrio : " + getFactorEquilibrio(root.getHijoDerecho()) + "\n\n";
            }
            if (root.getHijoIzquierdo() != null) {
                Cadena += toStringHijos(root.getHijoIzquierdo());
            }
            if (root.getHijoDerecho() != null) {
                Cadena += toStringHijos(root.getHijoDerecho());
            }

        }
        return Cadena;
    }

    public String toStringHijos(BinaryNode node) { // metodo usado para acceder e imprimir a los hijos de los hijos.
        String Cadena = "";
        if (node != null) {

            if (node.getHijoIzquierdo() != null) {
                Cadena += node.getHijoIzquierdo().toStringElemento();
                Cadena += "Padre: " + getPadre(node.getHijoIzquierdo()).toStringElemento();
                Cadena += node.getHijoIzquierdo().toStringHijos() + "Factor equilibrio : " + getFactorEquilibrio(node.getHijoIzquierdo()) + "\n\n";

            }
            if (node.getHijoDerecho() != null) {
                Cadena += node.getHijoDerecho().toStringElemento();
                Cadena += "Padre: " + getPadre(node.getHijoDerecho()).toStringElemento();
                Cadena += node.getHijoDerecho().toStringHijos() + "Factor equilibrio : " + getFactorEquilibrio(node.getHijoDerecho()) + "\n\n";

            }
            if (node.getHijoIzquierdo() != null) {
                Cadena += toStringHijos(node.getHijoIzquierdo());
            }
            if (node.getHijoDerecho() != null) {
                Cadena += toStringHijos(node.getHijoDerecho());
            }
        }
        return Cadena;
    }

}

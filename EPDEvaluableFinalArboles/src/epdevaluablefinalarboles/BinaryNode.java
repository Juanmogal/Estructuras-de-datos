package epdevaluablefinalarboles;

/*
* @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public class BinaryNode<E> {

    private BinaryNode hijoIzquierdo;
    private BinaryNode hijoDerecho;
    private LinkedList<Comparable> listaDeTweets;
    private Comparable elemento;
    private int altura;

    public BinaryNode(Comparable elemento) {
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.listaDeTweets = new LinkedList<>();
        this.elemento = elemento;
        this.altura = 0;
    }

    public BinaryNode getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(BinaryNode hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public BinaryNode getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(BinaryNode hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void getListaDeTweets() {
        if (this.listaDeTweets.isEmpty()) {
            System.out.println("Actualmente, este hashtag no es utilizado en ningún tweet");
        } else {
            for (int indice = 0; indice < listaDeTweets.size(); indice++) {
                System.out.println(listaDeTweets.getElement(indice));
            }
        }
    }

    public boolean anadirTweet(String tweet) {
        return this.listaDeTweets.addEnd(tweet);
    }

    public Comparable getElemento() {
        return elemento;
    }

    public void setElemento(Comparable elemento) {
        this.elemento = elemento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        if (altura < 0) {
            System.out.println("Altura de la rama no válida");
        } else {
            this.altura = altura;
        }
    }

    public String toStringHijos() {
        String cadena = "";

        if (getHijoIzquierdo() != null) {
            cadena += "Hijo izquierdo: " + getHijoIzquierdo().getElemento() + "\n";
        } else {
            cadena += "Hijo izquierdo: null" + "\n";
        }
        if (getHijoDerecho() != null) {
            cadena += "Hijo derecho: " + getHijoDerecho().getElemento() + "\n";
        } else {
            cadena += "Hijo derecho: null" + "\n";
        }

        return cadena;

    }

    public String toStringElemento() {
        String cadena = " ";

        cadena += this.elemento + "\n";

        return cadena;

    }

}

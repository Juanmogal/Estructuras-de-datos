package epdevaluablefinalarboles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
* @author Juan Moreno Galbarro
 * DNI: 47426785-A
 */
public class main {

    public static void main(String[] args) {

        AVLTree arbol = new AVLTree();

        String fichero = "data\\hashtag.txt"; // fichero de hasthags
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(fichero);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) { // mientras sigan existienod lineas en el fichero
                arbol.anadirElemento(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {

            archivo = new File("data\\tweets.txt"); //fichero de tweets
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                int inicio = 0;
                int fin = 0;
                String hashtag;
                int i = 0;
                while ((fin < linea.length() + 1) && inicio != -1) {
                    inicio = linea.indexOf("#", i);
                    if (inicio != -1) {
                        fin = linea.indexOf(" ", inicio);
                        if (fin == -1) {
                            fin = linea.length();
                        }
                        hashtag = linea.substring(inicio, fin);
                        BinaryNode node = arbol.find(hashtag);
                        if (node != null) {
                            node.anadirTweet(linea);
                        }
                    }
                    i = fin;
                    fin++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //Imprimimos el arbol entero.
        System.out.println(arbol.toString());

        //Buscamos la lista de tweets que incluyan el hashtag que introducimos por parámetro llamando a la lista de tweets del Nodo que nos devuelve el metodo find
        arbol.find("#madrid").getListaDeTweets();

    }
}

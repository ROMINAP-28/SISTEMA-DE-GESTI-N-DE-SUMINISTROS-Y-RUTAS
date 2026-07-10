
package Estructura;

public class ArbolABB<T extends Comparable<T>> { //Anyely y Romina
    private NodoGenerico<T> raiz;

    public ArbolABB() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoGenerico<T> insertarRecursivo(NodoGenerico<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoGenerico<>(dato);
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(
                    insertarRecursivo(nodo.getIzquierdo(), dato)
            );

        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(
                    insertarRecursivo(nodo.getDerecho(), dato)
            );
        }

        return nodo;
    }

    public T buscar(T dato) {
        NodoGenerico<T> encontrado = buscarRecursivo(raiz, dato);

        if (encontrado != null) {
            return encontrado.getDato();
        }

        return null;
    }
    
    public boolean contiene(T dato) {
        return buscar(dato) != null;
    }

    private NodoGenerico<T> buscarRecursivo(NodoGenerico<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        if (dato.equals(nodo.getDato())) {
            return nodo;
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            return buscarRecursivo(
                    nodo.getIzquierdo(),
                    dato
            );

        } else {
            return buscarRecursivo(
                    nodo.getDerecho(),
                    dato
            );
        }
    }

    public void inOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(NodoGenerico<T> nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.getIzquierdo());
            System.out.println(nodo.getDato());
            inOrdenRecursivo(nodo.getDerecho());
        }
    }

    public void preOrden() {
        preOrdenRecursivo(raiz);
    }

    private void preOrdenRecursivo(NodoGenerico<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato());
            preOrdenRecursivo(nodo.getIzquierdo());
            preOrdenRecursivo(nodo.getDerecho());
        }
    }

    public void postOrden() {
        postOrdenRecursivo(raiz);
    }

    private void postOrdenRecursivo(NodoGenerico<T> nodo) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.getIzquierdo());
            postOrdenRecursivo(nodo.getDerecho());
            System.out.println(nodo.getDato());
        }
    }
    
    private NodoGenerico<T> obtenerMenor(NodoGenerico<T> nodo) {

        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }

        return nodo;
    }
    
    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }
    
    private NodoGenerico<T> eliminarRecursivo(NodoGenerico<T> nodo, T dato) {

        if (nodo == null) {
            return null;
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(
                    eliminarRecursivo(nodo.getIzquierdo(), dato));

        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(
                    eliminarRecursivo(nodo.getDerecho(), dato));

        } else {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            NodoGenerico<T> sucesor = obtenerMenor(nodo.getDerecho());
            nodo.setDato(sucesor.getDato());
            nodo.setDerecho(
                    eliminarRecursivo(
                            nodo.getDerecho(),
                            sucesor.getDato()
                    )
            );
        }

        return nodo;
    }
    
    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(NodoGenerico<T> nodo) {

        if (nodo == null){
            return 0;
        }
        int izquierda = alturaRecursiva(nodo.getIzquierdo());
        int derecha = alturaRecursiva(nodo.getDerecho());

        return Math.max(izquierda, derecha) + 1;
    }
    
    public int cantidadNodos() {
        return contar(raiz);
    }

    private int contar(NodoGenerico<T> nodo) {

        if (nodo == null){
            return 0;
        }
        return 1
                + contar(nodo.getIzquierdo())
                + contar(nodo.getDerecho());
    }   

    public NodoGenerico<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoGenerico<T> raiz) {
        this.raiz = raiz;
    }
}

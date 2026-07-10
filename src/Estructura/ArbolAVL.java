
//Anyely
package Estructura;

public class ArbolAVL<T extends Comparable<T>> {
    private NodoGenerico<T> raiz; // Romina


    public ArbolAVL() {
        raiz = null;

    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public NodoGenerico<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoGenerico<T> raiz) {
        this.raiz = raiz;
    }

    private int altura(NodoGenerico<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        return nodo.getAltura();
    }

    private int mayor(int izquierda, int derecha) {

        if (izquierda > derecha) {
            return izquierda;
        }

        return derecha;
    }

    private int balance(NodoGenerico<T> nodo) {

        if (nodo == null) {
            return 0;
        }

        return altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    private NodoGenerico<T> rotacionDerecha(NodoGenerico<T> nodo) {

        NodoGenerico<T> nuevoPadre = nodo.getIzquierdo();

        NodoGenerico<T> subArbol = nuevoPadre.getDerecho();

        nuevoPadre.setDerecho(nodo);

        nodo.setIzquierdo(subArbol);

        nodo.setAltura(
                mayor(
                        altura(nodo.getIzquierdo()),
                        altura(nodo.getDerecho())
                ) + 1
        );

        nuevoPadre.setAltura(
                mayor(
                        altura(nuevoPadre.getIzquierdo()),
                        altura(nuevoPadre.getDerecho())
                ) + 1
        );

        return nuevoPadre;
    }

    private NodoGenerico<T> rotacionIzquierda(NodoGenerico<T> nodo) {

        NodoGenerico<T> nuevoPadre = nodo.getDerecho();

        NodoGenerico<T> subArbol = nuevoPadre.getIzquierdo();

        nuevoPadre.setIzquierdo(nodo);

        nodo.setDerecho(subArbol);

        nodo.setAltura(
                mayor(
                        altura(nodo.getIzquierdo()),
                        altura(nodo.getDerecho())
                ) + 1
        );

        nuevoPadre.setAltura(
                mayor(
                        altura(nuevoPadre.getIzquierdo()),
                        altura(nuevoPadre.getDerecho())
                ) + 1
        );

        return nuevoPadre;

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
                    insertarRecursivo(
                            nodo.getIzquierdo(),
                            dato
                    )
            );

        } else if (dato.compareTo(nodo.getDato()) > 0) {

            nodo.setDerecho(
                    insertarRecursivo(
                            nodo.getDerecho(),
                            dato
                    )
            );

        } else {

            return nodo;
        }

        nodo.setAltura(
                1 + mayor(
                        altura(nodo.getIzquierdo()),
                        altura(nodo.getDerecho())
                )
        );
        int factorBalance = balance(nodo);
        
        if (factorBalance > 1
                && dato.compareTo(nodo.getIzquierdo().getDato()) < 0) {

            return rotacionDerecha(nodo);
        }
        
        if (factorBalance < -1
                && dato.compareTo(nodo.getDerecho().getDato()) > 0) {

            return rotacionIzquierda(nodo);
        }
        
        if (factorBalance > 1
                && dato.compareTo(nodo.getIzquierdo().getDato()) > 0) {

            nodo.setIzquierdo(
                    rotacionIzquierda(nodo.getIzquierdo())
            );

            return rotacionDerecha(nodo);
        }

        if (factorBalance < -1
                && dato.compareTo(nodo.getDerecho().getDato()) < 0) {

            nodo.setDerecho(
                    rotacionDerecha(nodo.getDerecho())
            );

            return rotacionIzquierda(nodo);
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

    private NodoGenerico<T> buscarRecursivo(NodoGenerico<T> nodo, T dato) {

        if (nodo == null) {
            return null;
        }

        if (dato.compareTo(nodo.getDato()) == 0) {
            return nodo;
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), dato);
        }

        return buscarRecursivo(nodo.getDerecho(), dato);
    }

    public boolean contiene(T dato) {
        return buscar(dato) != null;
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

            if (nodo.getIzquierdo() == null
                    && nodo.getDerecho() == null) {
                return null;
            }

           
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }

            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            NodoGenerico<T> sucesor =
                    obtenerMenor(nodo.getDerecho());

            nodo.setDato(sucesor.getDato());

            nodo.setDerecho(
                    eliminarRecursivo(
                            nodo.getDerecho(),
                            sucesor.getDato()
                    )
            );
        }

        nodo.setAltura(
                mayor(
                        altura(nodo.getIzquierdo()),
                        altura(nodo.getDerecho())
                ) + 1
        );

        int factorBalance = balance(nodo);

        if (factorBalance > 1
                && balance(nodo.getIzquierdo()) >= 0) {

            return rotacionDerecha(nodo);
        }

        if (factorBalance > 1
                && balance(nodo.getIzquierdo()) < 0) {

            nodo.setIzquierdo(
                    rotacionIzquierda(nodo.getIzquierdo())
            );

            return rotacionDerecha(nodo);
        }

        if (factorBalance < -1
                && balance(nodo.getDerecho()) <= 0) {

            return rotacionIzquierda(nodo);
        }

        if (factorBalance < -1
                && balance(nodo.getDerecho()) > 0) {

            nodo.setDerecho(
                    rotacionDerecha(nodo.getDerecho())
            );

            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoGenerico<T> obtenerMenor(NodoGenerico<T> nodo) {

        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }

        return nodo;
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

    public int cantidadNodos() {
        return contar(raiz);
    }

    private int contar(NodoGenerico<T> nodo) {

        if (nodo == null) {
            return 0;
        }

        return 1
                + contar(nodo.getIzquierdo())
                + contar(nodo.getDerecho());
    }

}


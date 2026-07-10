//Anyely
package Estructura;

public class ArbolAVL<T extends Comparable<T>> {
    private NodoGenerico<T> raiz;

    public ArbolAVL() {
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    private int altura(NodoGenerico<T> nodo) {
        return (nodo == null) ? 0 : nodo.getAltura();
    }

    private int maximo(int a, int b) {
        return (a > b) ? a : b;
    }

    private int factorBalance(NodoGenerico<T> nodo) {
        return (nodo == null) ? 0 : altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    private NodoGenerico<T> rotacionDerecha(NodoGenerico<T> y) {
        NodoGenerico<T> x = y.getIzquierdo();
        NodoGenerico<T> t2 = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(t2);

        y.setAltura(maximo(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        x.setAltura(maximo(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        return x;
    }

    private NodoGenerico<T> rotacionIzquierda(NodoGenerico<T> x) {
        NodoGenerico<T> y = x.getDerecho();
        NodoGenerico<T> t2 = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(t2);

        x.setAltura(maximo(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        y.setAltura(maximo(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        return y;
    }

    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoGenerico<T> insertarRecursivo(NodoGenerico<T> nodo, T dato) {
        if (nodo == null) return new NodoGenerico<>(dato);

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), dato));
        } else {
            return nodo;
        }

        nodo.setAltura(1 + maximo(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
        int balance = factorBalance(nodo);

        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) < 0) {
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) > 0) {
            return rotacionIzquierda(nodo);
        }
        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) > 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) < 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

    public T buscar(T dato) {
        NodoGenerico<T> encontrado = buscarRecursivo(raiz, dato);
        return (encontrado != null) ? encontrado.getDato() : null;
    }

    private NodoGenerico<T> buscarRecursivo(NodoGenerico<T> nodo, T dato) {
        if (nodo == null || dato.compareTo(nodo.getDato()) == 0) return nodo;

        if (dato.compareTo(nodo.getDato()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), dato);
        }
        return buscarRecursivo(nodo.getDerecho(), dato);
    }

    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private NodoGenerico<T> eliminarRecursivo(NodoGenerico<T> nodo, T dato) {
        if (nodo == null) return null;

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), dato));
        } else {
            if (nodo.getIzquierdo() == null) return nodo.getDerecho();
            if (nodo.getDerecho() == null) return nodo.getIzquierdo();

            NodoGenerico<T> menor = obtenerMenor(nodo.getDerecho());
            nodo.setDato(menor.getDato());
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), menor.getDato()));
        }

        if (nodo == null) return null;

        nodo.setAltura(1 + maximo(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
        int balance = factorBalance(nodo);

        if (balance > 1 && factorBalance(nodo.getIzquierdo()) >= 0) {
            return rotacionDerecha(nodo);
        }
        if (balance > 1 && factorBalance(nodo.getIzquierdo()) < 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && factorBalance(nodo.getDerecho()) <= 0) {
            return rotacionIzquierda(nodo);
        }
        if (balance < -1 && factorBalance(nodo.getDerecho()) > 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

    private NodoGenerico<T> obtenerMenor(NodoGenerico<T> nodo) {
        NodoGenerico<T> actual = nodo;
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }

    public ListaDoble<T> preOrdenPersistencia() {
        ListaDoble<T> listaExport = new ListaDoble<>();
        llenarPreOrden(raiz, listaExport);
        return listaExport;
    }

    private void llenarPreOrden(NodoGenerico<T> nodo, ListaDoble<T> lista) {
        if (nodo != null) {
            lista.insertar(nodo.getDato());
            llenarPreOrden(nodo.getIzquierdo(), lista);
            llenarPreOrden(nodo.getDerecho(), lista);
        }
    }

    public int contarNodos() {
        return contarRecursivo(raiz);
    }

    private int contarRecursivo(NodoGenerico<T> nodo) {
        if (nodo == null) return 0;
        return 1 + contarRecursivo(nodo.getIzquierdo()) + contarRecursivo(nodo.getDerecho());
    }

    public void limpiar() {
        raiz = null;
    }

    public NodoGenerico<T> getRaiz() { return raiz; }
    public void setRaiz(NodoGenerico<T> raiz) { this.raiz = raiz; }
}

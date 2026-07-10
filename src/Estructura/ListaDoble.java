
package Estructura;

public class ListaDoble<T> { //Anyely y Romina

    private NodoGenerico<T> primero;
    private NodoGenerico<T> ultimo;
    private NodoGenerico<T> actual;

    public ListaDoble() {
        primero = null;
        ultimo = null;
        actual = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }
    
    public int tamaño() {

        int contador = 0;

        NodoGenerico<T> aux = primero;

        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }

        return contador;
    }
    public void insertar(T dato) {
        NodoGenerico<T> nuevo = new NodoGenerico<>(dato);

        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
    }

    public NodoGenerico<T> buscar(T dato) {
        NodoGenerico<T> aux = primero;

        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    
    public NodoGenerico<T> siguiente() {

        if (actual == null) {
            actual = primero;
        } else {
            actual = actual.getSiguiente();
        }

        return actual;
    }
    
    public NodoGenerico<T> anterior() {

        if (actual == null) {
            actual = ultimo;
        } else {
            actual = actual.getAnterior();
        }

        return actual;
    }
    
    public void reiniciarRecorrido() {
        actual = null;
    }
    
    public boolean eliminar(T dato) {
        NodoGenerico<T> actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                if (actual == primero) {
                    primero = primero.getSiguiente();

                    if (primero != null) {
                        primero.setAnterior(null);
                    } else {
                        ultimo = null;
                    }

                } else if (actual == ultimo) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(null);

                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void mostrar() {
        NodoGenerico<T> aux = primero;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public NodoGenerico<T> getPrimero() {
        return primero;
    }

    public NodoGenerico<T> getUltimo() {
        return ultimo;
    }
    
    public NodoGenerico<T> getActual() {
        return actual;
    }
}

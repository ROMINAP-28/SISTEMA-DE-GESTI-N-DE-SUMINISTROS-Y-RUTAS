//Anyely
package Estructura;

public class ListaDoble<T> {

    private NodoGenerico<T> primero;
    private NodoGenerico<T> ultimo;

    public ListaDoble() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
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
}

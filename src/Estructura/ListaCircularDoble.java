//Anyely
package Estructura;

public class ListaCircularDoble<T> {

    private NodoGenerico<T> primero;
    private NodoGenerico<T> ultimo;

    public ListaCircularDoble() {
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
            primero.setSiguiente(primero);
            primero.setAnterior(primero);

        } else {
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        }
    }

    public NodoGenerico<T> buscar(T dato) {
        if (estaVacia()) {
            return null;
        }

        NodoGenerico<T> aux = primero;

        do {
            if (aux.getDato().equals(dato)) {
                return aux;
            }

            aux = aux.getSiguiente();

        } while (aux != primero);
        return null;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        NodoGenerico<T> aux = primero;

        do {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        } while (aux != primero);
    }

    public boolean eliminar(T dato) {

        if (estaVacia()) {
            return false;
        }

        NodoGenerico<T> actual = primero;

        do {
            if (actual.getDato().equals(dato)) {
                if (primero == ultimo) {
                    primero = null;
                    ultimo = null;

                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());

                    if (actual == primero) {
                        primero = actual.getSiguiente();
                    }

                    if (actual == ultimo) {
                        ultimo = actual.getAnterior();
                    }
                }
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != primero);
        return false;

    }

    public NodoGenerico<T> getPrimero() {
        return primero;
    }

    public NodoGenerico<T> getUltimo() {
        return ultimo;
    }

}


package Estructura;

public class ListaCircularDoble<T> {//Anyely y Romina
    
    //Atributos
    private NodoGenerico<T> primero;
    private NodoGenerico<T> ultimo;
    private NodoGenerico<T> actual;
    
    //Constructor inicializado en null
    public ListaCircularDoble() {
        primero = null;
        ultimo = null;
        actual = null;
    }
    
    //Metodo que comprueba si la lista esta vacia
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
    
    public NodoGenerico<T> siguiente() {

        if (estaVacia()) {
            return null;
        }

        if (actual == null) {
            actual = primero;
        } else {
            actual = actual.getSiguiente();
        }

        return actual;
    }
    
    public NodoGenerico<T> anterior() {

        if (estaVacia()) {
            return null;
        }

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
    
    public int tamaño() {

        if (estaVacia()) {
            return 0;
        }

        int contador = 0;

        NodoGenerico<T> aux = primero;

        do {

            contador++;

            aux = aux.getSiguiente();

        } while (aux != primero);

        return contador;
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
    
    public NodoGenerico<T> getActual() {
        return actual;
    }

}

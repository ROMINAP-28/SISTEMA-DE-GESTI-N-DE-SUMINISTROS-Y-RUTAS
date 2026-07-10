//Anyely
package Estructura;

public class ColaPrioridad<T> {
    private NodoGenerico<T> frente;
    
    public ColaPrioridad() {
        frente = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void insertar(T dato) {
        NodoGenerico<T> nuevo = new NodoGenerico<>(dato);

        if (estaVacia()) {
            frente = nuevo;

        } else {
            NodoGenerico<T> aux = frente;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
        }
    }

    public T eliminar() {
        if (estaVacia()) {
            return null;
        }

        T dato = frente.getDato();
        frente = frente.getSiguiente();

        if (frente != null) {
            frente.setAnterior(null);
        }

        return dato;
    }

    public T primero() {
        if (estaVacia()) {
            return null;
        }
        return frente.getDato();
    }

    public void mostrar() {
        NodoGenerico<T> aux = frente;

        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public NodoGenerico<T> getFrente() {
        return frente;
    }

    public void setFrente(NodoGenerico<T> frente) {
        this.frente = frente;
    }
}

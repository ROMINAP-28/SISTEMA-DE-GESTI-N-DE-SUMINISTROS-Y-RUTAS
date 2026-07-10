//Anyely
package Estructura;

public class PilaHistorial<T> {
    private NodoGenerico<T> cima;

    public PilaHistorial() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void push(T dato) {
        NodoGenerico<T> nuevo = new NodoGenerico<>(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public T pop() {
        if (estaVacia()) {
            return null;
        }

        T dato = cima.getDato();
        cima = cima.getSiguiente();
        return dato;
    }

    public T peek() {
        if (estaVacia()) {
            return null;
        }
        return cima.getDato();
    }

    public void mostrar() {
        NodoGenerico<T> aux = cima;
        while(aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
    
    public void vaciar() {
        cima = null;
    }

    public NodoGenerico<T> getCima() {
        return cima;
    }

    public void setCima(NodoGenerico<T> cima) {
        this.cima = cima;
    }
}

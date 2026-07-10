
package Estructura;

import Libreria.Paquete;

public class ColaPrioridad {  //Anyeli y Romina

    private NodoGenerico<Paquete> frente;

    public ColaPrioridad() {
        frente = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void insertar(Paquete paquete) {

        NodoGenerico<Paquete> nuevo = new NodoGenerico<>(paquete);

        // Cola vacía
        if (estaVacia()) {
            frente = nuevo;
            return;
        }

        // Si tiene mayor prioridad que el primero
        if (paquete.getPrioridad() > frente.getDato().getPrioridad()) {

            nuevo.setSiguiente(frente);
            frente.setAnterior(nuevo);
            frente = nuevo;
            return;
        }

        NodoGenerico<Paquete> actual = frente;

        while (actual.getSiguiente() != null &&
               actual.getSiguiente().getDato().getPrioridad() >= paquete.getPrioridad()) {

            actual = actual.getSiguiente();
        }

        nuevo.setSiguiente(actual.getSiguiente());

        if (actual.getSiguiente() != null) {
            actual.getSiguiente().setAnterior(nuevo);
        }

        actual.setSiguiente(nuevo);
        nuevo.setAnterior(actual);
    }

    public Paquete eliminar() {

        if (estaVacia()) {
            return null;
        }

        Paquete dato = frente.getDato();

        frente = frente.getSiguiente();

        if (frente != null) {
            frente.setAnterior(null);
        }

        return dato;
    }

    public Paquete primero() {

        if (estaVacia()) {
            return null;
        }

        return frente.getDato();
    }

    public int size() {

        int contador = 0;

        NodoGenerico<Paquete> aux = frente;

        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }

        return contador;
    }

    public void vaciar() {
        frente = null;
    }

    public void mostrar() {

        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return;
        }

        NodoGenerico<Paquete> aux = frente;

        while (aux != null) {

            System.out.println(aux.getDato());

            aux = aux.getSiguiente();
        }
    }

    public NodoGenerico<Paquete> getFrente() {
        return frente;
    }
}
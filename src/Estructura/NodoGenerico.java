/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura;

public class NodoGenerico<T> {
    private T dato;
    private NodoGenerico<T> siguiente;
    private NodoGenerico<T> anterior;
    private NodoGenerico<T> izquierdo;
    private NodoGenerico<T> derecho;
    private int altura;

    public NodoGenerico() {
    }

    public NodoGenerico(T dato) {
        this.dato = dato;
        this.altura = 1; 
    }

    public T getDato() { 
        return dato; 
    }
    public void setDato(T dato) { 
        this.dato = dato; 
    }

    public NodoGenerico<T> getSiguiente() { 
        return siguiente; 
    }
    public void setSiguiente(NodoGenerico<T> siguiente) { 
        this.siguiente = siguiente; 
    }

    public NodoGenerico<T> getAnterior() { 
        return anterior; 
    }
    public void setAnterior(NodoGenerico<T> anterior) { 
        this.anterior = anterior; 
    }

    public NodoGenerico<T> getIzquierdo() { 
        return izquierdo; 
    }
    public void setIzquierdo(NodoGenerico<T> izquierdo) { 
        this.izquierdo = izquierdo; 
    }

    public NodoGenerico<T> getDerecho() { 
        return derecho; 
    }
    public void setDerecho(NodoGenerico<T> derecho) { 
        this.derecho = derecho; 
    }

    public int getAltura() { 
        return altura; 
    }
    public void setAltura(int altura) { 
        this.altura = altura; 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

public class Paquete {

    private int idPaquete;
    private double peso;
    private String direccion;
    private String categoria;
    private int prioridad;

    public Paquete() {
    }

    public Paquete(int idPaquete, double peso, String direccion, String categoria, int prioridad) {
        this.idPaquete = idPaquete;
        this.peso = peso;
        this.direccion = direccion;
        this.categoria = categoria;
        this.prioridad = prioridad;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    @Override
    public String toString() {
        return "[ID: " + idPaquete + "] | Cat: " + categoria + " | Peso: " + peso + "kg | Destino: " + direccion + " | Prioridad: " + prioridad;
    }
}

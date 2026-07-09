/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria;

public class Vehiculo {

    private String placa;
    private String conductor;
    private String tipo;
    private String estado;

    public Vehiculo() {
    }
    
    public Vehiculo(String placa, String conductor, String tipo, String estado) {
        this.placa = placa;
        this.conductor = conductor;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
    return "Placa: " + placa + " | Conductor: " + conductor + " (" + tipo + ") - Estado: " + estado;
    }
}


package Interfaces;

import Libreria.Paquete;


public interface IPaqueteService { //Romina
    void registrarPaquete(Paquete p);
    void modificarPaquete(Paquete p);
    Paquete buscatPaquete(int id);
    void elimnarPquete(int id);
    
}

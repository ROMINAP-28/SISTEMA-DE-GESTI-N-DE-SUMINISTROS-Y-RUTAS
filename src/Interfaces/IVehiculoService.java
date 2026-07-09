
package Interfaces;

import Libreria.Vehiculo;


public interface IVehiculoService { //Romina
    
    void registraVehiculo(Vehiculo v);
    Vehiculo buscarVehiculo(String placa);
    
}

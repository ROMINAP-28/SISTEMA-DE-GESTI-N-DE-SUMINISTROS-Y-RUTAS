/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Libreria.Categoria;

/**
 *
 * @author romin
 */
public interface ICategoriaService { //ROMINA
         void registraVehiculo (Categoria c);
         Categoria buscarCategoria(int codigo);
         void eliminarCategoria(int codigo);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.Dao;

import com.julian.model.Vehiculo;
import com.julian.model.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Siel
 */
@Local
public interface VehiculoDaoLocal {
    void addVehiculo(Vehiculo vehiculo);
    
    void editVehiculo(Vehiculo vehiculo);
    
    void deleteVehiculo (int vehiculoId);
    
    Vehiculo getVehiculo(int vehiculoId);
    
    Vehiculo getVehiculo(String modelo);
    
    public List<Vehiculo> getAllVehiculo();
    
    //public List<Venta> getAllVentas(Vehiculo vehiculoId); 
}

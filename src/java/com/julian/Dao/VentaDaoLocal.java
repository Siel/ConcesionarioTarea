/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.Dao;

import com.julian.model.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Siel
 */
@Local
public interface VentaDaoLocal {
    void addVenta(Venta ventas);
    
    void editVenta(Venta ventas);
    
    void deleteVenta (int ventasId);
    
    Venta getVenta(int ventasId);
    
    Venta getVenta(String matricula);
    
    public List<Venta> getAllVentas();
}

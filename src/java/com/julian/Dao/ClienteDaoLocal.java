/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.Dao;

import com.julian.model.Cliente;
import com.julian.model.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Siel
 */
@Local
public interface ClienteDaoLocal {
    void addCliente(Cliente cliente);
    
    void editCliente(Cliente cliente);
    
    void deleteCliente (int clienteId);
    
    Cliente getCliente(int clienteId);
    
    public List<Cliente> getAllClientes();
    
    //public List<Venta> getAllVentas(Cliente clienteId);
    
}

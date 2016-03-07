/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.Dao;

import com.julian.model.Cliente;
import com.julian.model.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Siel
 */
@Stateless
public class ClienteDao implements ClienteDaoLocal {

    @PersistenceContext
    private EntityManager em;    
    
    @Override
    public void addCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void editCliente(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void deleteCliente(int clienteId) {
        em.remove(getCliente(clienteId));
    }

    @Override
    public Cliente getCliente(int clienteId) {
        return em.find(Cliente.class, clienteId);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return em.createNamedQuery("Cliente.getAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /*@Override
    public List<Venta> getAllVentas(Cliente clienteId) {
        return em.createNamedQuery("Venta.getAll").getResultList();
    }
*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.Dao;

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
public class VentaDao implements VentaDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addVenta(Venta venta) {
        em.persist(venta);
    }

    @Override
    public void editVenta(Venta venta) {
        em.merge(venta);
    }

    @Override
    public void deleteVenta(int ventaId) {
        em.remove(getVenta(ventaId));
    }

    @Override
    public Venta getVenta(int ventaId) {
        return em.find(Venta.class, ventaId);
    }

    @Override
    public List<Venta> getAllVentas() {
        return em.createNamedQuery("Venta.getAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Venta getVenta(String matricula) {
        List<Venta> v = em.createQuery(
        "SELECT v FROM Venta v WHERE v.matricula = :matricula")
                .setParameter("matricula", matricula)
                .setMaxResults(1)
                .getResultList();
        if(v.isEmpty()){
            return new Venta();
        }
        return v.get(0);
    }

    
}

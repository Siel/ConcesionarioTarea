/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.Dao;

import com.julian.model.Vehiculo;
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
public class VehiculoDao implements VehiculoDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addVehiculo(Vehiculo vehiculo) {
        em.persist(vehiculo);
    }

    @Override
    public void editVehiculo(Vehiculo vehiculo) {
        em.merge(vehiculo);
    }

    @Override
    public void deleteVehiculo(int vehiculoId) {
        em.remove(getVehiculo(vehiculoId));
    }

    @Override
    public Vehiculo getVehiculo(int vehiculoId) {
        return em.find(Vehiculo.class, vehiculoId);
    }

    @Override
    public List<Vehiculo> getAllVehiculo() {
        return em.createNamedQuery("Vehiculo.getAll").getResultList();
    }
    
    @Override
    public Vehiculo getVehiculo(String modelo) {
        List<Vehiculo> v = em.createQuery(
        "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
                .setParameter("modelo", modelo)
                .setMaxResults(1)
                .getResultList();
        if(v.isEmpty()){
            return new Vehiculo();
        }
        return v.get(0);
    }
/*
    @Override
    public List<Venta> getAllVentas(Vehiculo vehiculoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

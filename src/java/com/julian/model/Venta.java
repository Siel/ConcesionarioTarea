/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.print.DocFlavor;
/**
 *
 * @author Siel
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name="Venta.getAll",query="SELECT e FROM Venta e"))
public class Venta implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int ventaId;
    @JoinColumn(name="clienteId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vehiculoId")
    private Vehiculo vehiculo;
    @Column
    private String matricula;
    @Column
    private String fecha;

    public Venta() {
    }

    public Venta(int ventaId, Cliente cliente, Vehiculo vehiculo, String matricula,String fecha) {
        this.ventaId = ventaId;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.matricula = matricula;
        this.fecha = fecha;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        if (!cliente.getVentas().contains(this)) { 
            cliente.getVentas().add(this);
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        if (!vehiculo.getVentas().contains(this)) { 
            vehiculo.getVentas().add(this);
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}

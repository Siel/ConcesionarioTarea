/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Siel
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name="Vehiculo.getAll",query="SELECT e FROM Vehiculo e"))
public class Vehiculo implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int vehiculoId;
    @Column
    private String fabricante;
    @Column
    private String fecha;
    @Column
    private String cilindraje;
    @Column
    private String potencia;
    @Column
    private int precio;
    @Column
    private boolean transmision;
    @Column
    private String imagen;
    @Column
    private String modelo;
    
    @OneToMany(mappedBy="vehiculo")
    private List<Venta> ventas;

    public List<Venta> getVentas() {
        return ventas;
    }

    public void addVenta(Venta venta) {
        this.ventas.add(venta);
        if (venta.getVehiculo() != this) {
            venta.setVehiculo(this);
        }
    }
    
    public Vehiculo() {
    }

    public Vehiculo(int vehiculoId, String fabricante, String fecha, String cilindraje, String potencia, int precio, boolean transmision, String imagen, String modelo) {
        this.vehiculoId = vehiculoId;
        this.fabricante = fabricante;
        this.fecha = fecha;
        this.cilindraje = cilindraje;
        this.potencia = potencia;
        this.precio = precio;
        this.transmision = transmision;
        this.imagen = imagen;
        this.modelo = modelo;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean getTransmision() {
        return transmision;
    }

    public void setTransmision(boolean transmision) {
        this.transmision = transmision;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

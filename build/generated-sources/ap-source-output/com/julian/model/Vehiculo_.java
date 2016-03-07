package com.julian.model;

import com.julian.model.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T23:19:25")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> fecha;
    public static volatile SingularAttribute<Vehiculo, String> potencia;
    public static volatile SingularAttribute<Vehiculo, String> cilindraje;
    public static volatile SingularAttribute<Vehiculo, Integer> precio;
    public static volatile SingularAttribute<Vehiculo, Integer> vehiculoId;
    public static volatile SingularAttribute<Vehiculo, Boolean> transmision;
    public static volatile SingularAttribute<Vehiculo, String> imagen;
    public static volatile ListAttribute<Vehiculo, Venta> ventas;
    public static volatile SingularAttribute<Vehiculo, String> fabricante;
    public static volatile SingularAttribute<Vehiculo, String> modelo;

}
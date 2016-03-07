package com.julian.model;

import com.julian.model.Cliente;
import com.julian.model.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-06T23:19:25")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, String> fecha;
    public static volatile SingularAttribute<Venta, String> matricula;
    public static volatile SingularAttribute<Venta, Integer> ventaId;
    public static volatile SingularAttribute<Venta, Vehiculo> vehiculo;

}
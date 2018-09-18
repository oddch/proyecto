package Entidades;

import Entidades.Factura;
import Entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(FacturaHasProducto.class)
public class FacturaHasProducto_ { 

    public static volatile SingularAttribute<FacturaHasProducto, Integer> id;
    public static volatile SingularAttribute<FacturaHasProducto, Integer> cantidad;
    public static volatile SingularAttribute<FacturaHasProducto, Producto> idproducto;
    public static volatile SingularAttribute<FacturaHasProducto, Factura> idfactura;

}
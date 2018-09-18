package Entidades;

import Entidades.FacturaHasProducto;
import Entidades.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, Proveedor> proveedorList;
    public static volatile SingularAttribute<Producto, Integer> precio;
    public static volatile SingularAttribute<Producto, String> tipoProducto;
    public static volatile SingularAttribute<Producto, String> imagen;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile ListAttribute<Producto, FacturaHasProducto> facturaHasProductoList;
    public static volatile SingularAttribute<Producto, Integer> idproducto;
    public static volatile SingularAttribute<Producto, String> nombre;

}
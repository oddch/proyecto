package Entidades;

import Entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> nombreProveedor;
    public static volatile SingularAttribute<Proveedor, Integer> idproveedor;
    public static volatile SingularAttribute<Proveedor, Integer> telefonoComercial;
    public static volatile SingularAttribute<Proveedor, String> correoComercial;
    public static volatile SingularAttribute<Proveedor, String> direccionComercial;
    public static volatile SingularAttribute<Proveedor, Producto> productoIdproducto;
    public static volatile SingularAttribute<Proveedor, String> observacion;

}
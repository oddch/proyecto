package Entidades;

import Entidades.FacturaHasProducto;
import Entidades.Pedido;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> fecha;
    public static volatile SingularAttribute<Factura, Integer> totalFactura;
    public static volatile SingularAttribute<Factura, Usuario> clienteId;
    public static volatile ListAttribute<Factura, Pedido> pedidoList;
    public static volatile ListAttribute<Factura, FacturaHasProducto> facturaHasProductoList;
    public static volatile SingularAttribute<Factura, Integer> idfactura;

}
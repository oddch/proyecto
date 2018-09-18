package Entidades;

import Entidades.Calificacion;
import Entidades.Factura;
import Entidades.Ruta;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, String> estado;
    public static volatile ListAttribute<Pedido, Ruta> rutaList;
    public static volatile ListAttribute<Pedido, Usuario> usuarioList;
    public static volatile SingularAttribute<Pedido, Factura> facturaIdfactura;
    public static volatile SingularAttribute<Pedido, Usuario> clienteId;
    public static volatile SingularAttribute<Pedido, Integer> idpedido;
    public static volatile SingularAttribute<Pedido, Date> fechaPedido;
    public static volatile ListAttribute<Pedido, Calificacion> calificacionList;

}
package Entidades;

import Entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Ruta.class)
public class Ruta_ { 

    public static volatile SingularAttribute<Ruta, Integer> idruta;
    public static volatile SingularAttribute<Ruta, String> direccion;
    public static volatile SingularAttribute<Ruta, String> imagen;
    public static volatile SingularAttribute<Ruta, String> localidad;
    public static volatile SingularAttribute<Ruta, String> telefono;
    public static volatile SingularAttribute<Ruta, String> observacion;
    public static volatile SingularAttribute<Ruta, Pedido> pedidoIdpedido;

}
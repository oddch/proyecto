package Entidades;

import Entidades.Asistencia;
import Entidades.Factura;
import Entidades.Pedido;
import Entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, Integer> estado;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, Integer> documento;
    public static volatile ListAttribute<Usuario, Pedido> pedidoList;
    public static volatile SingularAttribute<Usuario, String> nombres;
    public static volatile ListAttribute<Usuario, Asistencia> asistenciaList;
    public static volatile SingularAttribute<Usuario, String> tipoDocumento;
    public static volatile ListAttribute<Usuario, Pedido> pedidoList1;
    public static volatile ListAttribute<Usuario, Factura> facturaList;
    public static volatile SingularAttribute<Usuario, Integer> telefono;
    public static volatile SingularAttribute<Usuario, Rol> rolIdRol;
    public static volatile SingularAttribute<Usuario, String> email;

}
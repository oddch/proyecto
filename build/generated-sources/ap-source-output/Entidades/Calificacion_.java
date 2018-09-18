package Entidades;

import Entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, String> descripcion;
    public static volatile SingularAttribute<Calificacion, String> calificado;
    public static volatile SingularAttribute<Calificacion, String> calificacion;
    public static volatile SingularAttribute<Calificacion, Pedido> pedidoId;
    public static volatile SingularAttribute<Calificacion, Integer> idcalificacion;

}
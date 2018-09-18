package Entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Registroasistencia.class)
public class Registroasistencia_ { 

    public static volatile SingularAttribute<Registroasistencia, Date> fecha;
    public static volatile SingularAttribute<Registroasistencia, Integer> idasistencia;
    public static volatile SingularAttribute<Registroasistencia, String> horaEntrada;
    public static volatile SingularAttribute<Registroasistencia, Date> insertado;
    public static volatile SingularAttribute<Registroasistencia, String> observaciones;
    public static volatile SingularAttribute<Registroasistencia, String> horaSalida;

}
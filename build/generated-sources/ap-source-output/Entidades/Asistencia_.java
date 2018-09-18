package Entidades;

import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Asistencia.class)
public class Asistencia_ { 

    public static volatile SingularAttribute<Asistencia, Usuario> usuarioIdUsuario;
    public static volatile SingularAttribute<Asistencia, Date> fecha;
    public static volatile SingularAttribute<Asistencia, Integer> idasistencia;
    public static volatile SingularAttribute<Asistencia, String> horaEntrada;
    public static volatile SingularAttribute<Asistencia, String> observaciones;
    public static volatile SingularAttribute<Asistencia, String> horaSalida;

}
package Entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Contacto.class)
public class Contacto_ { 

    public static volatile SingularAttribute<Contacto, Date> fecha;
    public static volatile SingularAttribute<Contacto, Integer> idcontacto;
    public static volatile SingularAttribute<Contacto, String> solicitud;
    public static volatile SingularAttribute<Contacto, String> asunto;
    public static volatile SingularAttribute<Contacto, String> mensaje;
    public static volatile SingularAttribute<Contacto, String> email;

}
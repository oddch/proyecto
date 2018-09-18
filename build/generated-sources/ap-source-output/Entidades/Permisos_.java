package Entidades;

import Entidades.Permisos;
import Entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-18T10:33:25")
@StaticMetamodel(Permisos.class)
public class Permisos_ { 

    public static volatile SingularAttribute<Permisos, String> nombreIngles;
    public static volatile SingularAttribute<Permisos, Permisos> permisoPadre;
    public static volatile SingularAttribute<Permisos, Integer> idPermiso;
    public static volatile SingularAttribute<Permisos, String> icon;
    public static volatile ListAttribute<Permisos, Permisos> permisosList;
    public static volatile ListAttribute<Permisos, Rol> rolList;
    public static volatile SingularAttribute<Permisos, String> nombre;
    public static volatile SingularAttribute<Permisos, String> url;

}
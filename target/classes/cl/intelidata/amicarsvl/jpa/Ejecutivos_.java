package cl.intelidata.amicarsvl.jpa;

import cl.intelidata.amicarsvl.jpa.Locales;
import cl.intelidata.amicarsvl.jpa.Proceso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "EclipseLink-2.5.2.v20140319-rNA", date = "2015-03-13T19:40:27")
@StaticMetamodel(Ejecutivos.class)
public class Ejecutivos_ {

    public static volatile ListAttribute<Ejecutivos, Proceso> procesoList;
    public static volatile SingularAttribute<Ejecutivos, Locales> localesidLocal1;
    public static volatile SingularAttribute<Ejecutivos, Date> fechaIngreso;
    public static volatile SingularAttribute<Ejecutivos, String> fechaModificacion;
    public static volatile SingularAttribute<Ejecutivos, Integer> idEjecutivo;
    public static volatile SingularAttribute<Ejecutivos, String> correoEjecutivo;
    public static volatile SingularAttribute<Ejecutivos, String> nombreEjecutivo;

}

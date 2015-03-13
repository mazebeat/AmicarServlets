package cl.intelidata.amicarsvl.jpa;

import cl.intelidata.amicarsvl.jpa.Proceso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "EclipseLink-2.5.2.v20140319-rNA", date = "2015-03-13T19:40:27")
@StaticMetamodel(Clientes.class)
public class Clientes_ {

    public static volatile ListAttribute<Clientes, Proceso> procesoList;
    public static volatile SingularAttribute<Clientes, String> rutCliente;
    public static volatile SingularAttribute<Clientes, Date> fecha;
    public static volatile SingularAttribute<Clientes, String> emailCliente;
    public static volatile SingularAttribute<Clientes, String> fonoParticular;
    public static volatile SingularAttribute<Clientes, Integer> idCliente;
    public static volatile SingularAttribute<Clientes, Integer> idGrupo;
    public static volatile SingularAttribute<Clientes, String> fonoCelular;
    public static volatile SingularAttribute<Clientes, String> nombreCliente;
    public static volatile SingularAttribute<Clientes, String> valorAuto;
    public static volatile SingularAttribute<Clientes, Integer> idBody;
    public static volatile SingularAttribute<Clientes, String> fonoComercial;
    public static volatile SingularAttribute<Clientes, String> nombreJrn;
    public static volatile SingularAttribute<Clientes, Boolean> desinscrito;
    public static volatile SingularAttribute<Clientes, String> modeloAuto;
    public static volatile SingularAttribute<Clientes, String> marcaAuto;

}

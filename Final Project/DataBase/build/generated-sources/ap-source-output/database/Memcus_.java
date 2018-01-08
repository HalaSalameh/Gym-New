package database;

import database.Customers;
import database.Membership;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Memcus.class)
public class Memcus_ { 

    public static volatile SingularAttribute<Memcus, Date> endDate;
    public static volatile SingularAttribute<Memcus, Membership> membership;
    public static volatile SingularAttribute<Memcus, Customers> customers;
    public static volatile SingularAttribute<Memcus, Date> startDate;

}
package database;

import database.Memcus;
import database.Payfor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Membership.class)
public class Membership_ { 

    public static volatile CollectionAttribute<Membership, Memcus> memcusCollection;
    public static volatile SingularAttribute<Membership, String> memName;
    public static volatile CollectionAttribute<Membership, Payfor> payforCollection;
    public static volatile SingularAttribute<Membership, Integer> memId;

}
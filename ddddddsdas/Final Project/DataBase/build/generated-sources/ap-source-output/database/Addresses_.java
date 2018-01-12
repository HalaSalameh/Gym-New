package database;

import database.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Addresses.class)
public class Addresses_ { 

    public static volatile SingularAttribute<Addresses, String> city;
    public static volatile SingularAttribute<Addresses, String> street;
    public static volatile CollectionAttribute<Addresses, User> userCollection;
    public static volatile SingularAttribute<Addresses, String> building;
    public static volatile SingularAttribute<Addresses, Integer> addressId;

}
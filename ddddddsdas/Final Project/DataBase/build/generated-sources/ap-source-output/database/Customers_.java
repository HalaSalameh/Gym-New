package database;

import database.Medicalsituation;
import database.Memcus;
import database.Payfor;
import database.Programs;
import database.Sections;
import database.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile CollectionAttribute<Customers, Memcus> memcusCollection;
    public static volatile SingularAttribute<Customers, Integer> cusid;
    public static volatile CollectionAttribute<Customers, Medicalsituation> medicalsituationCollection;
    public static volatile CollectionAttribute<Customers, Payfor> payforCollection;
    public static volatile SingularAttribute<Customers, User> userid;
    public static volatile CollectionAttribute<Customers, Sections> sectionsCollection;
    public static volatile SingularAttribute<Customers, Programs> programId;

}
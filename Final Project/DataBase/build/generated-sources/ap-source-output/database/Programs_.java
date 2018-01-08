package database;

import database.Customers;
import database.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Programs.class)
public class Programs_ { 

    public static volatile SingularAttribute<Programs, Integer> weeklyTrainingHour;
    public static volatile SingularAttribute<Programs, Employee> empId;
    public static volatile SingularAttribute<Programs, String> foodType;
    public static volatile CollectionAttribute<Programs, Customers> customersCollection;
    public static volatile SingularAttribute<Programs, Integer> programId;

}
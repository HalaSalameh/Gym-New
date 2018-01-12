package database;

import database.Classes;
import database.Customers;
import database.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Sections.class)
public class Sections_ { 

    public static volatile SingularAttribute<Sections, Classes> classId;
    public static volatile SingularAttribute<Sections, Double> hour;
    public static volatile SingularAttribute<Sections, Integer> level;
    public static volatile CollectionAttribute<Sections, Employee> employeeCollection;
    public static volatile CollectionAttribute<Sections, Customers> customersCollection;
    public static volatile SingularAttribute<Sections, Integer> sectionId;
    public static volatile SingularAttribute<Sections, Integer> day;
    public static volatile SingularAttribute<Sections, Integer> age;

}
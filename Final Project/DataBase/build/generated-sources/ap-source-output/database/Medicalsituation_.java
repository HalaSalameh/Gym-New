package database;

import database.Customers;
import database.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Medicalsituation.class)
public class Medicalsituation_ { 

    public static volatile SingularAttribute<Medicalsituation, String> measurment;
    public static volatile SingularAttribute<Medicalsituation, Employee> empId;
    public static volatile SingularAttribute<Medicalsituation, Customers> cusId;
    public static volatile SingularAttribute<Medicalsituation, Integer> medicalSituation;
    public static volatile SingularAttribute<Medicalsituation, String> diseases;
    public static volatile SingularAttribute<Medicalsituation, Double> weight;

}
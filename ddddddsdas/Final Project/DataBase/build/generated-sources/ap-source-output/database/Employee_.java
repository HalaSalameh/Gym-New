package database;

import database.Medicalsituation;
import database.Programs;
import database.Sections;
import database.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Integer> empId;
    public static volatile CollectionAttribute<Employee, Programs> programsCollection;
    public static volatile CollectionAttribute<Employee, Medicalsituation> medicalsituationCollection;
    public static volatile SingularAttribute<Employee, Integer> rank;
    public static volatile SingularAttribute<Employee, User> userid;
    public static volatile CollectionAttribute<Employee, Sections> sectionsCollection;

}
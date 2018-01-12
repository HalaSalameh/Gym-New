package database;

import database.Addresses;
import database.Customers;
import database.Employee;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Boolean> isEmp;
    public static volatile SingularAttribute<User, Boolean> gender;
    public static volatile SingularAttribute<User, Employee> mainEmp;
    public static volatile CollectionAttribute<User, Customers> customersCollection;
    public static volatile SingularAttribute<User, Date> dateOfBirth;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, Date> joinedDate;
    public static volatile SingularAttribute<User, Addresses> addressId;
    public static volatile SingularAttribute<User, Customers> mainCus;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> name;
    public static volatile CollectionAttribute<User, Employee> employeeCollection;
    public static volatile SingularAttribute<User, String> email;

}
package database;

import database.Sections;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:46:33")
@StaticMetamodel(Classes.class)
public class Classes_ { 

    public static volatile SingularAttribute<Classes, Integer> classId;
    public static volatile SingularAttribute<Classes, Integer> numOfHours;
    public static volatile SingularAttribute<Classes, String> className;
    public static volatile SingularAttribute<Classes, String> type;
    public static volatile SingularAttribute<Classes, String> classPeriod;
    public static volatile CollectionAttribute<Classes, Sections> sectionsCollection;

}
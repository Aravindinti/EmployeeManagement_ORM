JPA:
- Jakarta Persistence API .
- In older version , it was known as java persistence api.
- It is standard for ORM(Object Relational Mapping)
- One of the most popular implementation of ORM is hibernate.
- JPA is the most common way today to do database interaction using
  java.
- JPA is responsible for creating the queries based on the database
  which is being used.
- You just have to call appropriate methods of JPA.
Example:
For inserting record we have persist() method.
For deleting record we have remove() method.
Steps for using JPA:
1.Add appropriate Maven dependencies.
2.Annotate model class with JPA annotations.
3.Create persistence xml file in META-INF folder inside src/main/resources folder
4.Create appropriate properties in persistence.xml
5.create EntityManagerFactory
 Entitymanagerfactory is a heavy weight object and hence  only one object is created for one application
 6.Create EntityManager Object
 Entitymanager Object s light weight object and not thread safe and hence it s creatd for every
 database interaction
 7.Create EntityTransacton object
 8.perform database operation
 9.commit the transaction
 10.close Entitymanager object.
 11.close EntityManager object.
 
 <property name="hibernate.hbm2ddl.auto" value="update" ></property>
 create :
 It recreates the schema everytime .Hence it is not useful in production it is useful in development
 Update:
    It create the schema only if doesn't exist .  
 


Important Annotations for JPA
1. @Entity:

 It is used as class level.
   	        It denotes this class should be treated as table in database.
2. @Id : 

It is used on the field of the class which we want to be treated 
         as primary key.
3. @ElementCollection :
 It is used to map collection object with the table.
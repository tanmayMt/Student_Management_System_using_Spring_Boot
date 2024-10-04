package com.tanmay.studentmanagement.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity   //This annotation indicates that the class is a JPA entity, representing a database table.
@Getter   // This annotation automatically generates getter methods for all the fields in the class.
@Setter   // This annotation automatically generates setter methods for all the fields in the class.
@AllArgsConstructor //This annotation generates a constructor that takes all the fields as arguments.
@NoArgsConstructor //This annotation generates a no-argument constructor.
public class Student {
    @Id   //used to mark a field or property in a Java class as the unique identifier of an entity. It's equivalent to a primary key in a database table.
    @GeneratedValue(strategy=GenerationType.IDENTITY)  //This nnotation specifies that the database will automatically 
                                                       //generate a unique value for this primary key when a new entity is created.
    private Long id;
    private String firstName;
    private String lastName;
    @NaturalId(mutable=true)   //This annotation in Spring Data JPA indicates that a field or property should be used as a natural identifier for an entity. 
                                //This means that the field's value can be used to uniquely identify an entity, even if it's not the primary key.    Mutable: Indicates that the value of the field can be changed after the entity is persisted.
    private String email;
    private String department;
}

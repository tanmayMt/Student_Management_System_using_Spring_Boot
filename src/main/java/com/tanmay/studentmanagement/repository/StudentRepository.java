package com.tanmay.studentmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmay.studentmanagement.model.Student;

//StudentRepository interface declares a contract for managing Student entities 
//using Spring Data JPA. It inherits the CRUD operations from the JpaRepository 
//interface, providing a convenient way to perform data access tasks.
public interface StudentRepository extends JpaRepository<Student, Long>{

    Optional<Student> findByEmail(String email);

}

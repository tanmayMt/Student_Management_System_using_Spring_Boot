package com.tanmay.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tanmay.studentmanagement.model.Student;

@Service
//The @Service annotation in Spring Boot is used to indicate that a class provides a service to the application. 
//It's a component scan stereotype that tells Spring that the class is a bean and should be managed by the Spring IoC container.
//@Service annotation is a crucial tool in Spring Boot for organizing and managing application services. It promotes loose coupling, 
//dependency injection, and simplifies the development process.
public class StudentService implements IStudentService{

    @Override
    public Student addStudent(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStudent'");
    }

    @Override
    public List<Student> getStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudents'");
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStudent'");
    }

    @Override
    public Student getStudentById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentById'");
    }

    @Override
    public void deleteStudent(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }

}

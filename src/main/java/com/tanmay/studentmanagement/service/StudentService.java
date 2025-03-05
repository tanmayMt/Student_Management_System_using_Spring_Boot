package com.tanmay.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tanmay.studentmanagement.exception.StudentAlreadyExistsException;
import com.tanmay.studentmanagement.exception.StudentNotFoundException;
import com.tanmay.studentmanagement.model.Student;
import com.tanmay.studentmanagement.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
//The @Service annotation in Spring Boot is used to indicate that a class provides a service to the application. 
//It's a component scan stereotype that tells Spring that the class is a bean and should be managed by the Spring IoC container.
//@Service annotation is a crucial tool in Spring Boot for organizing and managing application services. It promotes loose coupling, 
//dependency injection, and simplifies the development process.
@RequiredArgsConstructor   //it automatically generates a constructor for the StudentService class that takes a StudentRepository as an argument and initializes the studentRepository field with it. 
public class StudentService implements IStudentService{
    private final StudentRepository studentRepository;//establishing a dependency between the StudentService class and the StudentRepository interface. It enables the StudentService 
                                                      //to access and utilize the data access capabilities provided by the StudentRepository implementation, promoting loose coupling, testability, and maintainability of the code.

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        if (studentAlreadyExists(student.getEmail())){
            throw  new StudentAlreadyExistsException(student.getEmail()+ " already exists!");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
            return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" +id));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry, student not found");
        }
        studentRepository.deleteById(id);
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}

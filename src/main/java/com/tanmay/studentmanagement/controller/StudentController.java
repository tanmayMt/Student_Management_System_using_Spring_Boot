package com.tanmay.studentmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanmay.studentmanagement.model.Student;
import com.tanmay.studentmanagement.service.IStudentService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("http://localhost:3000") //allowing client application to consume the backed

@RestController  //@RestController is a Spring annotation that tells Spring Boot 
                 //to treat a class as a RESTful controller. This means that the 
                 //methods within this class will be exposed as HTTP endpoints.
@RequestMapping("/students")  //The annotation @RequestMapping("/students") in Spring MVC is used to map incoming HTTP requests 
                              //with the URL pattern "/students" to a specific method within a controller class. 
                              //This means that whenever a client sends a request to the server with the URL "/students", 
                              //the annotated method will be executed to handle the request.
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){ //method that returns a list of students as a response in a Spring Boot application.
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
        //This method retrieves a list of students from a service, creates a response entity with the list 
        //and a "found" status code, and returns it to the caller. This could be used in a REST API endpoint
        //to handle a GET request for a list of students.
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){ //@RequestBody annotation used in Spring Boot to indicate that the request body of an HTTP request should be mapped to a specific Java object.
                                                             //This means that the incoming data in the request body will be automatically converted into a Java object based on the structure defined in the annotated class.
        return studentService.addStudent(student);
    }

    @PutMapping("/update/{id}") //The annotation @PutMapping("/update/{id}") is used in Spring MVC to define a HTTP PUT request handler method.
                                //This method will be invoked when a client sends a PUT request to the specified URL, where {id} represents 
                                //a placeholder for a variable path parameter. The method will typically update a resource with the given ID 
                                //using the data provided in the request body.
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){  //The @PathVariable Long id annotation indicates that the id parameter in the controller method should be extracted from the URL path and converted to a Long value.
                                                                                        //This makes it easier to create RESTful APIs that can handle different resources based on their unique identifiers.
        return studentService.updateStudent(student, id);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}

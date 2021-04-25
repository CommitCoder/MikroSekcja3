package com.sekcja3.students;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {



    // @GetMapping     @RequestMapping  same effect, works the same,   @GetMapping better choice
    @GetMapping("/hello")
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Witaj";
    }

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student();
        student.setFirstName("Arnold");
        student.setLastName("Boczek");
        student.setEmail("Marian_B@wp.pl");
        return student;
    }






}

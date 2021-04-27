package com.sekcja3.students;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // zapytanie w jsonie :)
public class StudentController {

    private StudentRepository studentRepository;


    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    // podawany Json w metodzie POST zostanie z automatu zmapowany na obiekt Javowy Student

    @PostMapping("students")
    public Student addStudent(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }





}

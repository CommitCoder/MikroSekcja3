package com.sekcja3.students.controller;


import com.sekcja3.students.repository.StudentRepository;
import com.sekcja3.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController // zapytanie w jsonie :)
@RequestMapping("/students") // /students początek każdego url w tym controlerze
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    // podawany Json w metodzie POST zostanie z automatu zmapowany na obiekt Javowy Student
    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent( @PathVariable  Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        //sprawdzamy czy jest coś w optionalu
        if(studentOptional.isPresent()){
            return ResponseEntity.ok(studentOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }






}

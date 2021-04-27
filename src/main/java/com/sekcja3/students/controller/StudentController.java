package com.sekcja3.students.controller;


import com.sekcja3.students.model.Student;
import com.sekcja3.students.repository.StudentRepository;
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



    // orElseGet() lepszy dla tego casa

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent( @PathVariable  Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // wykona się tylko wtedy gdy optional jest pusty
    }



//       @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable  Long id){
//       return studentRepository.findById(id)
//               .map(student -> ResponseEntity.ok(student))
//               .orElse(ResponseEntity.notFound().build());  // orElse wykonuje się zawsze nawet gdy .map() coś zwraca
//    }




}

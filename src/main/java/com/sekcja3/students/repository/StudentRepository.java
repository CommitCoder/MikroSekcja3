package com.sekcja3.students.repository;

import com.sekcja3.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository  //  extends JpaRepository  ->  tak naprawdę @Repository nie jest potrzebne ale dla czytelności
public interface StudentRepository extends JpaRepository<Student, Long> {

    // ctrl + spacja dużo fajnych podpowiedzi do nazw metod z JPA Repo
    List<Student> findByLastName(String lastName);


}

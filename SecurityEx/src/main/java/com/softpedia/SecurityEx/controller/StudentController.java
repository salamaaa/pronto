package com.softpedia.SecurityEx.controller;

import com.softpedia.SecurityEx.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1,"mohamed salama",100),
            new Student(2,"mostafa shakir",120)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }


}

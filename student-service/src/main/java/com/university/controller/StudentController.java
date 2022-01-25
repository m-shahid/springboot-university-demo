package com.university.controller;

import com.university.model.StudentRequest;
import com.university.model.StudentResponse;
import com.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public StudentResponse create(@RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }

    @GetMapping("/get/{id}")
    public StudentResponse getById(@PathVariable long id) {
        return studentService.getById(id);
    }
}

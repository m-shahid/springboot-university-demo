package com.university.service;

import com.university.entity.Student;
import com.university.model.StudentRequest;
import com.university.model.StudentResponse;
import com.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentResponse createStudent(StudentRequest request) {

        Student student = new Student();

        student.setEmail(request.getEmail());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAddressId(request.getAddressId());

        studentRepository.save(student);

        // ToDo : set address info before returning student response

        return new StudentResponse(student);
    }

    public StudentResponse getById(long id) {
        Student student = studentRepository.findById(id).get();

        // ToDo : set address info before returning student response

        return new StudentResponse(student);
    }

}

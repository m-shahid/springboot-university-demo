package com.university.service;

import com.university.entity.Student;
import com.university.feignclient.GenericFeignClient;
import com.university.model.AddressResponse;
import com.university.model.StudentRequest;
import com.university.model.StudentResponse;
import com.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ExternalServices externalServices;

    public StudentResponse createStudent(StudentRequest request) {

        Student student = new Student();

        student.setEmail(request.getEmail());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAddressId(request.getAddressId());

        studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(externalServices.getAddressResponse(student.getAddressId()));

        return studentResponse;
    }

    public StudentResponse getById(long id) {
        Student student = studentRepository.findById(id).get();

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(externalServices.getAddressResponse(student.getAddressId()));

        return studentResponse;
    }

}

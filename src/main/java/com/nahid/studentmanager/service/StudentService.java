package com.nahid.studentmanager.service;

import com.nahid.studentmanager.model.Student;
import com.nahid.studentmanager.repo.StudentRepo;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();
    private final StudentRepo studentRepo;

    @PostConstruct
    public void init() {
        populateInitialStudents();
    }

    private void populateInitialStudents() {
        // Add 3 sample students
        studentList.add(new Student(
            "STU001",
            "Emma Johnson",
            "emma.johnson@email.com",
            20,
            "Female",
            "CSE",
            "01712345678",
            "123 University Ave, Campus City, ST 12345"
        ));

        studentList.add(new Student(
            "STU002",
            "Michael Chen",
            "michael.chen@email.com",
            19,
            "Male",
            "EEE",
            "01798765432",
            "456 Student Blvd, College Town, ST 67890"
        ));

        studentList.add(new Student(
            "STU003",
            "Sarah Davis",
            "sarah.davis@email.com",
            21,
            "Female",
            "SWE",
            "01745678901",
            "789 Academic Dr, Study Hall, ST 13579"
        ));

        studentRepo.saveAll(studentList);
    }

    public boolean alreadyExist(Student student){

//        for(Student s : studentList){
//            if(s.getStudentId().equals(student.getStudentId()) || s.getEmail().equals(student.getEmail())){
//                return true;
//            }
//        }
        String sId = student.getStudentId();
        String email = student.getEmail();
        if(studentRepo.existsById(sId) || studentRepo.existsByEmail(email)){
            return true;
        }

        return false;
    }

    public void addStudent(Student student){
//        studentList.add(student);
        studentRepo.save(student);
        System.out.println("Student Saved to Database successfully.");
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

}

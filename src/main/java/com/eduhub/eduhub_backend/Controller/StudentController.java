package com.eduhub.eduhub_backend.Controller;


import com.eduhub.eduhub_backend.Component.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("Student")

    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Elangovan", "S");
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @GetMapping("Stendent")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "ram", "s"));
        studentList.add(new Student(2, "ramk", "p"));
        studentList.add(new Student(3, "ramp", "sk"));
        studentList.add(new Student(4, "ramo", "sl"));
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
   }

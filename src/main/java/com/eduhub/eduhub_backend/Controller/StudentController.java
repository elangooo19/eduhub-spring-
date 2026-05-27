package com.eduhub.eduhub_backend.Controller;


import com.eduhub.eduhub_backend.Component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("students")
    public ResponseEntity<Student> getStudent()
    {
        Student student=new Student(1,"Aarockya","Raj");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @GetMapping("studentlist")
    public  ResponseEntity<List<Student>>getStudents()
    {
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Aarockya","Raj"));
        studentList.add(new Student(2,"Elangovan","S"));
        studentList.add(new Student(3,"Manikandan","S"));
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @GetMapping("{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("firstName") String firstName,
                                                       @PathVariable("lastName") String lastName)
    {
        Student student=new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    @GetMapping("query")
    public ResponseEntity<Student>StudentRequestVariable(@RequestParam int studentId,
                                                         @RequestParam String firstName,
                                                         @RequestParam String lastName){
        Student student=new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateStudent(@PathVariable("id") int id,
                                        @RequestBody Student student){
        return ResponseEntity.accepted().body(student);

    }


}
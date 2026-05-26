package com.eduhub.eduhub_backend.Controller;

import com.eduhub.eduhub_backend.Component.Company;
import com.eduhub.eduhub_backend.Component.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CourseController {

   @Autowired
    CourseService courseService;


    @Autowired
    Company company;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("get-course")
    public String getCourse(){
        return courseService.getCourse();

    }

    @GetMapping("Company")
    public String getcompany(){
        return company.getcompany();
    }
}



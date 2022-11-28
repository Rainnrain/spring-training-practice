package com.cydeo.controller;


import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Version", "Cydeo.V3")
                .body( new ResponseWrapper( "Courses sucessfully retreived", courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId){

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Version", "Cydeo.V3")
                .body(new ResponseWrapper("Course: "+courseId+ " found successfully", courseService.getCourseById(courseId)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCourse(@RequestBody CourseDTO courseDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Version", "Cydeo.V3")
                .body(new ResponseWrapper("Course "+courseDTO.getName()+ "has been created",courseService.createCourse(courseDTO)));
    }


}

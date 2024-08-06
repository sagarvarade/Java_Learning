package com.JavaTechieConsumer.controller;

import com.JavaTechieConsumer.dto.CourseRequestDTO;
import com.JavaTechieConsumer.dto.CourseResponseDTO;
import com.JavaTechieConsumer.dto.ServiceResponse;
import com.JavaTechieConsumer.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/add-course")
    public ServiceResponse<CourseResponseDTO> addNewCourse(@RequestBody  CourseRequestDTO courseRequestDTO){
        return facultyService.addNewCourseToDashBoard(courseRequestDTO);
    }

    @GetMapping("/get-all-courses")
    public ServiceResponse<List<CourseResponseDTO>> fetchAllCourses(){
        return facultyService.fetchAllCourses();
    }

    @GetMapping("/get-by-id/{id}")
    public ServiceResponse<List<CourseResponseDTO>> findCourseById(@PathVariable("id") Integer id){
        return facultyService.fetchByIdPathVariable(id);
    }

    @GetMapping("/get-by-param")
    public ServiceResponse<List<CourseResponseDTO>> findCourseByParam(@RequestParam(value = "id",required = false) Integer id){
        return facultyService.findCourseByParam(id);
    }
}

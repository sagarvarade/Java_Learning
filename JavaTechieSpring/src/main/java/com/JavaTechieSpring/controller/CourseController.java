package com.JavaTechieSpring.controller;

import com.JavaTechieSpring.dataTransferObject.CourseRequestDTO;
import com.JavaTechieSpring.dataTransferObject.CourseResponseDTO;
import com.JavaTechieSpring.dataTransferObject.ServiceResponse;
import com.JavaTechieSpring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired  //Setter injection
    private CourseService courseService;

    /*  Constructor Injection
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
     */

    @PostMapping("/add-course")
    //@RequestMapping(value="add-course",method = RequestMethod.POST)
    public ServiceResponse<CourseResponseDTO> addCourse(@RequestBody CourseRequestDTO course){
        return new ServiceResponse<>(HttpStatus.CREATED,courseService.onBoardNewCourse(course));
    }

    @GetMapping("/get-all-courses")
    public ServiceResponse<List<CourseResponseDTO>> findAllCourse(){
        return new ServiceResponse<>(HttpStatus.OK,courseService.viewAllCourses());
    }

    @GetMapping("/get-course/path-variable/{id}")
    public ServiceResponse<CourseResponseDTO> getByIDByPathVariable(@PathVariable("id") Integer id){
        return new ServiceResponse<>(HttpStatus.OK,courseService.getCourseById(id));
    }

    @GetMapping("/get-course/request-param")
    public ServiceResponse<CourseResponseDTO> getByRequestParam(@RequestParam(value = "id",required = false) Integer id){
        return new ServiceResponse<>(HttpStatus.OK,courseService.getCourseById(id));
    }

    @DeleteMapping("/delete-course-by-id/{id}")
    public ServiceResponse<CourseResponseDTO> deleteByIDByPathVariable(@PathVariable("id") Integer id){
        courseService.deleteCourseFromDb(id);
        return new ServiceResponse<CourseResponseDTO>(HttpStatus.NO_CONTENT,null);
    }

    @PutMapping("/{id}")
    public ServiceResponse<CourseResponseDTO> updateCourse(@PathVariable("id")  int id,@RequestBody CourseRequestDTO course ){
        return new ServiceResponse<CourseResponseDTO>(HttpStatus.OK,courseService.updateCourse(id,course));
    }
}

package com.JavaTechieSpring.controller;

import com.JavaTechieSpring.DTO.CourseRequestDTO;
import com.JavaTechieSpring.DTO.CourseResponseDTO;
import com.JavaTechieSpring.DTO.ServiceResponse;
import com.JavaTechieSpring.service.CourseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    final Logger log= LoggerFactory.getLogger(CourseController.class);
    @Autowired  //Setter injection
    private CourseService courseService;

    /*  Constructor Injection
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
     */

    @PostMapping("/add-course")
    //@RequestMapping(value="add-course",method = RequestMethod.POST)
    public ServiceResponse<CourseResponseDTO> addCourse(@RequestBody @Valid CourseRequestDTO courseRequestDTO){
        return new ServiceResponse<>(HttpStatus.CREATED,courseService.onBoardNewCourse(courseRequestDTO));
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
    public ServiceResponse<CourseResponseDTO> updateCourse(@PathVariable("id")  int id,@RequestBody @Valid CourseRequestDTO course ){
        return new ServiceResponse<CourseResponseDTO>(HttpStatus.OK,courseService.updateCourse(id,course));
    }

    @GetMapping("/log")
    public String printLogger(){
        log.trace("Trace message");
        log.debug("Debug message");
        log.info("Info message");
        log.warn("WARN message");
        log.error("Error message");
        return "Log printed";
    }
}

package com.JavaTechieSpring.service;

import com.JavaTechieSpring.DTO.CourseRequestDTO;
import com.JavaTechieSpring.DTO.CourseResponseDTO;
import com.JavaTechieSpring.Exception.CourseServiceBusinessException;
import com.JavaTechieSpring.entity.CourseEntity;
import com.JavaTechieSpring.repository.CourseRepository;
import com.JavaTechieSpring.util.AppUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // create course Object in DB
    public CourseResponseDTO onBoardNewCourse(CourseRequestDTO course){
        CourseEntity courseEntity= AppUtils.mapRequestToCourseEntity(course);
        CourseResponseDTO  courseResponseDTO=AppUtils.mapCourseEntityToCourseResponse(courseRepository.save(courseEntity));
        courseResponseDTO.setCourseUniqueCode(UUID.randomUUID().toString().split("-")[0]);
        return  courseResponseDTO;
    }

    // Load all the course from DB
    public List<CourseResponseDTO> viewAllCourses(){
        Iterable<CourseEntity> courseEntities=courseRepository.findAll();
        return  StreamSupport.stream(courseEntities.spliterator(),false)
                .map(AppUtils::mapCourseEntityToCourseResponse)
                .collect(Collectors.toList());
    }

    // Get course by id
    @Operation(summary = "Find course by course  Id.")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Get course by id")
    })
    public CourseResponseDTO getCourseById(Integer id){
        CourseEntity courseEntity=courseRepository.findById(id).orElseThrow(()->new CourseServiceBusinessException(id+" not found is DB."));
        return  AppUtils.mapCourseEntityToCourseResponse(courseEntity);
    }
    //1:8

    // delete course from DB
    public void  deleteCourseFromDb(Integer id){
        courseRepository.deleteById(id);
    }

    // update the course
    public CourseResponseDTO updateCourse(int courseId,CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("not found"));
        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        return AppUtils.mapCourseEntityToCourseResponse(courseRepository.save(courseEntity));
    }
}

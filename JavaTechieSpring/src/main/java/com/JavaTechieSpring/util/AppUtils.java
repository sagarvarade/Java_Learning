package com.JavaTechieSpring.util;

import com.JavaTechieSpring.DTO.CourseRequestDTO;
import com.JavaTechieSpring.DTO.CourseResponseDTO;
import com.JavaTechieSpring.entity.CourseEntity;



public class AppUtils {

    public static CourseEntity mapRequestToCourseEntity(CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        courseEntity.setEmail(courseRequestDTO.getEmail());
        courseEntity.setContact(courseRequestDTO.getContact());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        return courseEntity;
    }

    public  static CourseResponseDTO mapCourseEntityToCourseResponse(CourseEntity courseEntity){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourseId(courseEntity.getCourseId());
        courseResponseDTO.setName(courseEntity.getName());
        courseResponseDTO.setTrainerName(courseEntity.getTrainerName());
        courseResponseDTO.setDuration(courseEntity.getDuration());
        courseResponseDTO.setStartDate(courseEntity.getStartDate());
        courseResponseDTO.setFees(courseEntity.getFees());
        courseResponseDTO.setCertificateAvailable(courseEntity.isCertificateAvailable());
        courseResponseDTO.setDescription(courseEntity.getDescription());
        courseResponseDTO.setCourseUniqueCode("");
        courseResponseDTO.setEmail(courseEntity.getEmail());
        courseResponseDTO.setContact(courseEntity.getContact());
        courseResponseDTO.setCourseType(courseEntity.getCourseType());
        return courseResponseDTO;
    }
}

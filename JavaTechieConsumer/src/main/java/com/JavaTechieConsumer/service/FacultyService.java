package com.JavaTechieConsumer.service;

import com.JavaTechieConsumer.dto.CourseRequestDTO;
import com.JavaTechieConsumer.dto.CourseResponseDTO;
import com.JavaTechieConsumer.dto.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyService {

    private static final String BASE_URL="http://localhost:7000";

    @Autowired
    private RestTemplate restTemplate;


    public ServiceResponse<CourseResponseDTO> addNewCourseToDashBoard(CourseRequestDTO courseRequestDTO){
        return restTemplate.postForObject(BASE_URL + "/course/add-course", courseRequestDTO, ServiceResponse.class);
    }

    public ServiceResponse<List<CourseResponseDTO>> fetchAllCourses(){
        return restTemplate.getForObject(BASE_URL+"/course/get-all-courses",ServiceResponse.class);
    }

    public ServiceResponse<List<CourseResponseDTO>> fetchByIdPathVariable(Integer id){
        return restTemplate.getForObject(BASE_URL+"/course/get-course/path-variable/"+id,ServiceResponse.class);
    }

    public ServiceResponse<List<CourseResponseDTO>> findCourseByParam(Integer id) {
        Map<String,Integer> map=new HashMap<>();
        map.put("id",id);
        return restTemplate.getForObject(BASE_URL+"/course/get-course/request-param",ServiceResponse.class,map);
    }
}

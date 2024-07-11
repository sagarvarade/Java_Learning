package com.jpalearn.Repository;

import com.jpalearn.Beans.Course;
import com.jpalearn.Beans.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial(){
        Course course=Course.builder().courseTitle("DSA").credit(10).build();
        CourseMaterial cm=CourseMaterial.builder().url("AAa.com").course(course).build();
        courseMaterialRepository.save(cm);
    }

    @Test
    public void getAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList=courseMaterialRepository.findAll();
        for(CourseMaterial cm:courseMaterialList){
            System.out.println(cm);
        }
    }
}
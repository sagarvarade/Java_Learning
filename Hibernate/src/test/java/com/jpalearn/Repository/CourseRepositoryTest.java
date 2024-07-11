package com.jpalearn.Repository;

import com.jpalearn.Beans.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courseList=courseRepository.findAll();
        for(Course cs:courseList){
            System.out.println(cs);

        }
    }
}
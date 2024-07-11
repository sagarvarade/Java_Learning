package com.jpalearn.Repository;

import com.jpalearn.Beans.Course;
import com.jpalearn.Beans.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public  void saveTeacher(){
        Course course=Course.builder().courseTitle("DSA").credit(10).build();
       // Course course=courseRepository.findById(1l).get();
        Teacher teacher=Teacher.builder().firstName("A").lastName("Z").courses(List.of(course)).build();
        teacherRepository.save(teacher);
    }

}
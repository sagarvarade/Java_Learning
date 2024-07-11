package com.jpalearn.Repository;

import com.jpalearn.Beans.Guardian;
import com.jpalearn.Beans.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest  //Will flush Data
@SpringBootTest  //Will not flush data
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepo;

    @Test
    public  void createStudent(){
        Guardian grd=Guardian.builder().name("Guarding").mobile("124").email("rdg@emc.vom").build();

        Student std=Student.builder()
                .emailId("abc@gml.com")
                .firstName("sagar")
                .lastName("varade")
                .guardian(grd)
                .build();
        studentRepo.save(std);
    }
    @Test
    public void getAllStudent(){
       List<Student> stdList=studentRepo.findAll();
       for(Student std:stdList){
           System.out.println(std);
       }
    }

    @Test
    public void getStudentByName(){
        List<Student> stdList=studentRepo.findByFirstName("sagar");
        for(Student std:stdList){
            System.out.println(std);
        }
    }

    @Test
    public void getStudentByNameContaining(){
        List<Student> stdList=studentRepo.findByFirstNameContaining("gar");
        for(Student std:stdList){
            System.out.println(std);
        }
    }

    @Test
    public void getJPQLQuery(){
        Student std=studentRepo.getStudentByEmailAddress("abc@gml.com");
        System.out.println(std);
    }
}
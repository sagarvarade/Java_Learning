package com.jpalearn.Repository;

import com.jpalearn.Beans.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest  //Will flush Data
@SpringBootTest  //Will not flush data
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepo;

    @Test
    public  void createStudent(){
        Student std=Student.builder()
                .emailId("abc@gml.com")
                .firstName("sagar")
                .lastName("varade")
                .guardianName("Guarding").guardianMobile("124").guardianEmail("rdg@emc.vom")
                .build();
        studentRepo.save(std);
    }
}
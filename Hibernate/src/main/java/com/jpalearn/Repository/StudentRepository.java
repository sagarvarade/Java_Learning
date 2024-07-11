package com.jpalearn.Repository;

import com.jpalearn.Beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull(String lastName);
    List<Student> findByGuardianName(String guardianName);
    List<Student> findByFirstNameAndLastNameNotNull(String firstName,String lastName);
    //JPQL Query
    @Query("select s from Student s where s.emailId=?1 ")
    Student getStudentByEmailAddress(String EmailId);


}

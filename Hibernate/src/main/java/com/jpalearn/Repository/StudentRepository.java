package com.jpalearn.Repository;

import com.jpalearn.Beans.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName,String lastName);
    //JPQL Query
    @Query("select s from Student s where s.emailId=?1 ")
    Student getStudentByEmailAddress(String EmailId);

    @Query("select s.firstName from Student s where s.emailId=?1 ")
    String getStudentFirstNameByEmailAddress(String EmailId);

    @Query(
           value = "select * from tbl_student s where  s.email_address=?1",
           nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String EmailId);
    //Named Param query
    @Query(
            value = "select * from tbl_student s where  s.email_address=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String EmailId);

    //Update Operations
    @Modifying
    @Transactional
    @Query(
            value="update tbl_student set firstName=?1 where email_address=?2",
            nativeQuery = true
    )
    int updateStudentByEmailId(String firstName,String emailId);
}

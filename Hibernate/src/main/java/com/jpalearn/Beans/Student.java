package com.jpalearn.Beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name="tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name="emailid_unique",
                columnNames = "email_address"
        )
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private  Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name="email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}

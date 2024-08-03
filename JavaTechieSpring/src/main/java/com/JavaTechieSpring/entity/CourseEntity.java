package com.JavaTechieSpring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="course_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String name;
    private String trainerName;
    private String duration;
    private Date startDate;
    private double fees;
    private boolean isCertificateAvailable;
    private String description;
}

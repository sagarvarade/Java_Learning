package com.JavaTechieConsumer.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CourseRequestDTO{
    private String name;
    private String trainerName;
    private String duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private Date startDate;
    private double fees;
    private boolean isCertificateAvailable;
    private String description;
    private String email;
    private String contact;
    private String courseType;
}

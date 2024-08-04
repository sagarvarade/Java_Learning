package com.JavaTechieSpring.DTO;


import com.JavaTechieSpring.annotation.CourseTypeValidation;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
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
    @NotBlank(message ="Name should not be blank.")
    private String name;
    @NotBlank(message ="trainerName should not be blank.")
    private String trainerName;
    @NotNull(message = "Duration can not be null")
    private String duration;
    @Past(message = "startDate can not be before current date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private Date startDate;
    @Min(value = 500,message = "Fee can't be less than 500")
    @Max(value = 10000,message = "Fee can't be above 10000")
    private double fees;
    private boolean isCertificateAvailable;
    @NotEmpty(message = "Description must not be empty")
    private String description;
    @NotNull
    @Email(message = "Pls provide proper email")
    private String email;
    private String contact;
    @CourseTypeValidation
    private String courseType;
}

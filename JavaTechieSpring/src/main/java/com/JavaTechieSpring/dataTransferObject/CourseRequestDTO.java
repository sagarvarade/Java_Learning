package com.JavaTechieSpring.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CourseRequestDTO {
    private String name;
    private String trainerName;
    private String duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private Date startDate;
    private double fees;
    private boolean isCertificateAvailable;
    private String description;
}

package com.JavaTechieSpring.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.util.List;

public class CourseTypeValidator implements ConstraintValidator<CourseTypeValidation,String>{

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> list=List.of("Live","Recording");
        System.out.println("Annotation checking : "+s);
        return list.contains(s);
    }
}

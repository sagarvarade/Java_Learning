package com.JavaTechieSpring.Exception;

public class CourseServiceBusinessException extends RuntimeException{

    private  String message;
    public CourseServiceBusinessException(String message) {
        super(message);
        this.message=message;
    }

    public String getDefaultMessage() {
        return  this.message;
    }
}

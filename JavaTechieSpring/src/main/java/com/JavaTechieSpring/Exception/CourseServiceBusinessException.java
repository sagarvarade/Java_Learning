package com.JavaTechieSpring.Exception;

public class CourseServiceBusinessException extends RuntimeException{

    private final String message;
    public CourseServiceBusinessException(String message) {
        super(message);
        this.message=message;
    }

    public String getDefaultMessage() {
        return  this.message;
    }
}

package com.JavaTechieSpring.execHandler;

import com.JavaTechieSpring.DTO.ErrorDto;
import com.JavaTechieSpring.DTO.ServiceResponse;
import com.JavaTechieSpring.Exception.CourseServiceBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResponse<?> handleMethodArgumentException(MethodArgumentNotValidException ex){
        ServiceResponse<?> serviceResponse=new ServiceResponse<>();
        List<ErrorDto> errorDtoList=new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(er->errorDtoList.add(new ErrorDto(er.getDefaultMessage())));
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST);
        serviceResponse.setErrorDto(errorDtoList);
        return serviceResponse;
    }

    @ExceptionHandler(CourseServiceBusinessException.class)
    public ServiceResponse<?> handleCourseServiceBusinessException(CourseServiceBusinessException exec){
        ServiceResponse<?> serviceResponse=new ServiceResponse<>();
        serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        serviceResponse.setErrorDto(List.of(new ErrorDto(exec.getDefaultMessage())));
        return  serviceResponse;
    }

    @ExceptionHandler(Exception.class)
    public ServiceResponse<?> exceptionHandler(Exception exec){
        ServiceResponse<?> serviceResponse=new ServiceResponse<>();
        serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        serviceResponse.setErrorDto(List.of(new ErrorDto("Exception at runtime")));
        return  serviceResponse;
    }

}

package com.JavaTechieSpring.dataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {
    private HttpStatus status;
    private T response;
}

package com.springEmail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
    private String toEmail;
    private String subject;
    private String messageBody;
    private String attachment;

}

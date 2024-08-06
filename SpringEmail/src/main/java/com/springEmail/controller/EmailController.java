package com.springEmail.controller;


import com.springEmail.dto.EmailRequest;
import com.springEmail.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email-service")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-mail")
    public String sendMail(@RequestBody EmailRequest emailRequest){
        return emailService.sendSimpleEmail(emailRequest);
    }

    @PostMapping("/send-mail-with-attachment")
    public String sendMailWithAttachment(@RequestBody EmailRequest emailRequest) throws MessagingException {
        System.out.println("Mail Send");
        return emailService.sendSimpleEmailWithAttachment(emailRequest);
    }

}

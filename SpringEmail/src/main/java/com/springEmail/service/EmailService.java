package com.springEmail.service;

import com.springEmail.dto.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private  String sender;

    public String sendSimpleEmail(EmailRequest emailRequest){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("javatechie@gmail.com");
        simpleMailMessage.setTo(emailRequest.getToEmail());
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getMessageBody());
        javaMailSender.send(simpleMailMessage);
        return "Email Successfully Send to "+emailRequest.getToEmail();
    }

    public String sendSimpleEmailWithAttachment(EmailRequest emailRequest) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("javatechie@gmail.com");
        mimeMessageHelper.setTo(emailRequest.getToEmail());
        mimeMessageHelper.setSubject(emailRequest.getSubject());
        mimeMessageHelper.setText(emailRequest.getMessageBody());

        FileSystemResource file=new FileSystemResource(new File(emailRequest.getAttachment()));
        mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getFilename()),file);
        return "Email Successfully Send to "+emailRequest.getToEmail()+" with attachment.";
    }

}

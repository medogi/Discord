package com.war.war.email;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
@Component
public class EmailSender {
  @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEMail,
            String subject,
            String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("luka.kevkhishvili167@ens.tsu.ge");
        message.setTo(toEMail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);



    }

}

package com.war.war;

import com.war.war.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/meow")
public class Test {
   @Autowired
    private EmailSender emailSender;


    @EventListener(ApplicationReadyEvent.class)
    @PostMapping()
    public void sendEmail() {
        emailSender.sendEmail("luka.kevkhishvili167@ens.tsu.ge",
                "this is subject",
                "this is body of email");
    }


}

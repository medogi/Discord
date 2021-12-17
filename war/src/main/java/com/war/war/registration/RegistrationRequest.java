package com.war.war.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class RegistrationRequest {
    private String name;
    private String userName;
    private int year;
    private int age;

    private String lastName;

    private String password;

    private String email;


}

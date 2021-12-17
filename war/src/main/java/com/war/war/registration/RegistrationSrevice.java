package com.war.war.registration;

import com.war.war.appuser.AppUser;
import com.war.war.appuser.AppUserRole;
import com.war.war.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationSrevice {
    private EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(

                        request.getName(),
                        request.getYear(),
                        request.getAge(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getUserName(),
                        AppUserRole.USER




                )
        );
    }

}

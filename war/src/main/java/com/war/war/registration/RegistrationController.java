package com.war.war.registration;

import com.war.war.appadmin.AppAdminServers;
import com.war.war.appuser.AppUser;
import com.war.war.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private RegistrationSrevice registrationSrevice;
    private AppUserService appUserService;

    @PostMapping("/reg")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationSrevice.register(request);
    }
    @PostMapping("/verify")
    public void register(@RequestParam int id) {
         appUserService.verifiychecker(id);
    }

    @GetMapping("/see")
    public List<AppAdminServers> register() {
       return appUserService.seeservers();
    }
    @PostMapping("/chose")
    public void choseserver(@RequestBody AppUserDTO appUserDTO) {
         appUserService.choseserver(appUserDTO);
    }
    @PostMapping("/cansel")
    public void canselserver() {
        appUserService.calselserver();
    }
}

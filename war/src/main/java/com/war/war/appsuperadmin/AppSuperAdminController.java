package com.war.war.appsuperadmin;

import com.war.war.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sup")
@AllArgsConstructor
public class AppSuperAdminController {

    private final SuperAdminService superAdminService;

    @DeleteMapping("/deluser")
    public void delete(@RequestParam String email) {

        superAdminService.deleteUser(email);

    }
    @PostMapping("/changerank")
    public void changerank(@RequestBody AppSuperAdminDTO appSuperAdminDTO){

        superAdminService.changerank(appSuperAdminDTO);

    }


}

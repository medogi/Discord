package com.war.war.appsuperadmin;

import com.war.war.appuser.AppUser;
import com.war.war.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SuperAdminService {
    private final AppSuperAdminRepositorie appRepositorie;


    public void deleteUser(String email) {
        AppUser appUser1 = ((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (appUser1.getAppUserRole().equals(AppUserRole.SUPERADMIN)) {
            AppUser appUser = new AppUser();
            appUser = appRepositorie.findByEmail(email);
            appRepositorie.delete(appUser);
        }

    }
//TODO: esec orjertu ar gavushvi api ar update ebs
    public void changerank(AppSuperAdminDTO appSuperAdminDTO) {
        AppUser appUser = ((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (appUser.getAppUserRole().equals(AppUserRole.SUPERADMIN)) {
            AppUser appUser1 = new AppUser();

            appUser1 = appRepositorie.findByEmail(appSuperAdminDTO.getEmail());

            appUser1.setAppUserRole(AppUserRole.valueOf(appSuperAdminDTO.getAppUserRole()));
            appRepositorie.save(appUser1);
        }
        }

}

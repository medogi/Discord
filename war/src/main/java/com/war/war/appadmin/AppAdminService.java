package com.war.war.appadmin;

import com.war.war.appuser.AppUser;
import com.war.war.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
public class AppAdminService {

    private final AppAdminRepositorie appAdminRepositorie;

    public void createserver(AppAdminDTO adminDTO){
        AppUser appUser = ((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (appUser.getAppUserRole().equals(AppUserRole.ADMIN)) {
            AppAdminServers appAdminServers = new AppAdminServers();
            appAdminServers.setDate(adminDTO.getDate());
            appAdminServers.setName(adminDTO.getName());
            appAdminServers.setSize(adminDTO.getSize());
            appAdminRepositorie.save(appAdminServers);
        }
        }

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
       Date date = new Date();
       List<AppAdminServers> appAdminServers=appAdminRepositorie.findAll();

       for (AppAdminServers appAdminServers1 : appAdminServers){
          Date date1= appAdminServers1.getDate();
          if( date1.before(date)){
              AppAdminServers appAdminServers2 = appAdminRepositorie.findByDate(date1);
          appAdminRepositorie.delete(appAdminServers2);
          }

       }
    }
}

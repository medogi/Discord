package com.war.war.appuser;

import com.war.war.appadmin.AppAdminRepositorie;
import com.war.war.appadmin.AppAdminServers;
import com.war.war.appsuperadmin.AppSuperAdminRepositorie;
import com.war.war.email.EmailSender;
import com.war.war.registration.AppUserDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    @Autowired
    private EmailSender emailSender;
    private final static String USER_NOT_FOUND_SMG =
            "user with this email %s not found";
    private final AppUserRepositorie appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppAdminRepositorie appAdminRepositorie;
    private final AppSuperAdminRepositorie appSuperAdminRepositorie;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_SMG, email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExist = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if (userExist) {
            throw new IllegalStateException("email already taken");
        }
        System.out.println(appUser);
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);


        int randomPIN = (int) (Math.random() * 9000) + 1000;
        String x = Integer.toString(randomPIN);
        appUser.setVer(randomPIN);

        appUserRepository.save(appUser);
        emailSender.sendEmail(appUser.getEmail(),
                "Thank you for using our Web Service. to veriviy your acount where's a code",
                x);
        return "it works";

    }

    //TODO: pirvelzze ar anichebs vericikacias adre pirdapir akeTebda exla orjer unda mimarto endpoint ze da unda tavidan gavushva api
    public void verifiychecker(int id) {
        AppUser appUser = appUserRepository.findByVer(id);
        appUser.setEnabled(true);
        appUser.setLocked(false);
        appUserRepository.save(appUser);

    }

    public List<AppAdminServers> seeservers() {
        AppUser appUser2 = ((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        if (appUser2.getAppUserRole().equals(AppUserRole.USER)) {

            List<AppAdminServers> list = appAdminRepositorie.findAllByAppUserNull();

            return list;
        }else {
            List<AppAdminServers>list;
            list=null;
            return list;
        }
    }

    public void choseserver(AppUserDTO appUserDTO) {
        AppUser appUser2 = ((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (appUser2.getAppUserRole().equals(AppUserRole.USER)) {

            System.out.println(((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
            AppUser appUser = ((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());


            String email = appUser.getEmail();

            AppUser appUser1 = appSuperAdminRepositorie.findByEmail(email);

            AppAdminServers appAdminServers = new AppAdminServers();
            appAdminServers = appAdminRepositorie.findByNameAndAppUserNull(appUserDTO.getName());
            appAdminServers.setAppUser(appUser1);

            appAdminRepositorie.save(appAdminServers);
        }
        }

        public void calselserver(){
            AppUser appUser2 = ((AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            AppUser appUser3=appUser2;
            if (appUser2.getAppUserRole().equals(AppUserRole.USER)) {


                AppAdminServers appAdminServers1= appAdminRepositorie.findByAppUser(appUser3);
                String name=appAdminServers1.getName();
                AppAdminServers appAdminServers = appAdminRepositorie.findByName(name);
                appAdminServers.setAppUser(null);

               appAdminRepositorie.save(appAdminServers);

            }
            }

}



package com.war.war.appsuperadmin;

import com.war.war.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSuperAdminRepositorie extends JpaRepository<AppUser, Long> {
    public AppUser findByEmail(String email);
}

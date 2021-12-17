package com.war.war.appuser;

import com.war.war.registration.AppUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepositorie extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    public AppUser findByVer(int id);

}

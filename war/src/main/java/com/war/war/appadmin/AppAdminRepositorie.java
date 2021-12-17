package com.war.war.appadmin;

import com.war.war.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppAdminRepositorie extends JpaRepository<AppAdminServers,Long> {

public List<AppAdminServers>findAllByAppUserNull();
public AppAdminServers findByNameAndAppUserNull(String name);
   public AppAdminServers findByName(String name);
   public AppAdminServers findByAppUser(AppUser appUser);
   public List<AppAdminServers> findAll();
   public AppAdminServers findByDate(Date date1);
   }

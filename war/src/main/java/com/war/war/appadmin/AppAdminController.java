package com.war.war.appadmin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adm")
@AllArgsConstructor
public class AppAdminController {
    private final AppAdminService appAdminService;

    @PostMapping("/create")
    public void create(@RequestBody AppAdminDTO adminDTO) {
    appAdminService.createserver(adminDTO);
    }
}

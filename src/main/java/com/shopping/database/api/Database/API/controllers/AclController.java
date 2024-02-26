package com.shopping.database.api.Database.API.controllers;

import com.shopping.database.api.Database.API.DTO.RequestBody.AddAccessDTO;
import com.shopping.database.api.Database.API.models.Acl;
import com.shopping.database.api.Database.API.repository.AclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db/acl")
public class AclController {
    @Autowired
    AclRepository aclRepository;
    @PostMapping("/add")
    public void registerAccess(@RequestBody AddAccessDTO addAccessDTO) {
        Acl acl=new Acl();
        acl.setOperation(addAccessDTO.getOperation());
        acl.setRequestor(addAccessDTO.getRequestor());
        aclRepository.save(acl);
    }
}

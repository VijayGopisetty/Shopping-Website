package com.shopping.database.api.Database.API.controllers;

import com.shopping.database.api.Database.API.DTO.RequestBody.AddAccessDTO;
import com.shopping.database.api.Database.API.DTO.ResponseBody.AclConfigDTO;
import com.shopping.database.api.Database.API.models.Acl;
import com.shopping.database.api.Database.API.repository.AclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/validate")
    public ResponseEntity isAccessAvailable(@RequestParam String requestor, @RequestParam String operation){
        Acl acl=aclRepository.getConfiguration(requestor,operation);
        if(acl!=null){
            return new ResponseEntity<>(new AclConfigDTO(true), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(new AclConfigDTO(false), HttpStatus.OK);
    }
}

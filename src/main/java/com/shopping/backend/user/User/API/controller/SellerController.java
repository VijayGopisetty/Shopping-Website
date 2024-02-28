package com.shopping.backend.user.User.API.controller;

import com.shopping.backend.user.User.API.DTO.RequestBody.SellerProductRegistrationDTO;
import com.shopping.backend.user.User.API.DTO.generaluseDTO.GeneralMessageDTO;
import com.shopping.backend.user.User.API.exceptions.UnAuthorizedException;
import com.shopping.backend.user.User.API.exceptions.UserNotFoundException;
import com.shopping.backend.user.User.API.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @PostMapping("/product/register")
    public ResponseEntity registerProduct(@RequestBody SellerProductRegistrationDTO sellerProductRegistrationDTO){
        //Call database API to register product
        //Call Email API to notify seller that product got registered on portal
       try{
           SellerProductRegistrationDTO resp=sellerService.register(sellerProductRegistrationDTO);
           return new ResponseEntity(resp, HttpStatus.CREATED);
       }
       catch(UnAuthorizedException unAuthorizedException){
           return new ResponseEntity(new GeneralMessageDTO(unAuthorizedException.getMessage()),HttpStatus.UNAUTHORIZED);
        }
       catch(UserNotFoundException userNotFoundException){
           return new ResponseEntity(new GeneralMessageDTO(userNotFoundException.getMessage()),HttpStatus.NOT_FOUND);
       }
       catch(RuntimeException runtimeException){
           return new ResponseEntity(new GeneralMessageDTO(runtimeException.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}

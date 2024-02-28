package com.shopping.backend.user.User.API.service;

import com.shopping.backend.user.User.API.DTO.RequestBody.SellerProductRegistrationDTO;
import com.shopping.backend.user.User.API.DTO.generaluseDTO.UserDTO;
import com.shopping.backend.user.User.API.exceptions.UnAuthorizedException;
import com.shopping.backend.user.User.API.exceptions.UserNotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
@Service
public class SellerService {
    public SellerProductRegistrationDTO register(SellerProductRegistrationDTO sellerProductRegistrationDTO){
        UUID sellerId=sellerProductRegistrationDTO.getSellerId();
        //I need tto check tht this user is a register user or not
        //If not raise exception
        //If yes, check if this user is a seller or not
        //If not seller throw unauthorized exception
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate=new RestTemplate();
        HttpEntity httpEntity=new HttpEntity<>(httpHeaders);
        String url="http://localhost:8083/db/user/getuser?id="+sellerId.toString();
        ResponseEntity<UserDTO> userResp=restTemplate.exchange(url, HttpMethod.GET,httpEntity,UserDTO.class);
        if(userResp.getBody()==null){
            throw new UserNotFoundException(String.format("User with id %s does not exist",sellerId.toString()));
        }
        if(!userResp.getBody().getType().equals("SELLER")){
            throw new UnAuthorizedException(String.format("User with id %s is not have access to this operation",sellerId.toString()));
        }
        // Now call db API to save product
        String urlProduct="http://localhost:8083/db/product/add";
        HttpEntity httpEntityProduct=new HttpEntity<>(sellerProductRegistrationDTO,httpHeaders);
        ResponseEntity<SellerProductRegistrationDTO> respProduct= restTemplate.exchange(urlProduct,HttpMethod.POST,httpEntityProduct, SellerProductRegistrationDTO.class);
        if(respProduct.getBody()==null){
            throw new RuntimeException("Product addition was not successful!!");
        }
        return respProduct.getBody();
    }
}

package com.shopping.backend.FrontAPI.Controller;

import com.shopping.backend.FrontAPI.DTO.UserSignUpDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class PortalUserController {
    @PostMapping("/signup")
    public UserSignUpDTO signup(@RequestBody UserSignUpDTO userSignUpDTO){
        String url="http://localhost:8083/db/user/add";
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<UserSignUpDTO> entity=new HttpEntity<UserSignUpDTO>(userSignUpDTO,headers);
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.exchange(url,HttpMethod.POST,entity, UserSignUpDTO.class).getBody();
    }
}

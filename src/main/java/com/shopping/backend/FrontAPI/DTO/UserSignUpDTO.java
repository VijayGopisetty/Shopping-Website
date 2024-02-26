package com.shopping.backend.FrontAPI.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSignUpDTO {
    String name;
    String email;
    String password;
    Long contactNumber;
    String Address;
    String type;

}


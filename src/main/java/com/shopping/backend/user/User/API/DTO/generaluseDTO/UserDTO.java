package com.shopping.backend.user.User.API.DTO.generaluseDTO;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    UUID id;
    String name;
    String email;
    String password;
    Long contactNumber;
    String Address;
    String type;
}

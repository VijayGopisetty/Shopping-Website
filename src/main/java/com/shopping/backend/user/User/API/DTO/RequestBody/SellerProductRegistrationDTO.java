package com.shopping.backend.user.User.API.DTO.RequestBody;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SellerProductRegistrationDTO {
    String productName;
    int quantity;
    int price;
    UUID sellerId;
    String productType;
}

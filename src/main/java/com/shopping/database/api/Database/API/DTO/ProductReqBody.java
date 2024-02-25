package com.shopping.database.api.Database.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductReqBody {
    String productName;
    int price;
    int quantity;
    String productType;
    UUID sellerId;
}

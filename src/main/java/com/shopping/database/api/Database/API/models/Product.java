package com.shopping.database.api.Database.API.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    UUID id;
    String ProductName;
    int price;
    int quantity;
    PortalUser seller;
    double rating;
    String productType;

}

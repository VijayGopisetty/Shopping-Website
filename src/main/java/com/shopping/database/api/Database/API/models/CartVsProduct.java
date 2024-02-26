package com.shopping.database.api.Database.API.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartVsProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    UUID cartId;
    UUID productId;
}

package com.shopping.database.api.Database.API.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Acl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String requestor;
    String operation;
}

package com.shopping.database.api.Database.API.repository;

import com.shopping.database.api.Database.API.models.Acl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AclRepository extends JpaRepository<Acl, UUID> {
}

package com.shopping.database.api.Database.API.repository;

import com.shopping.database.api.Database.API.models.Acl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Repository
public interface AclRepository extends JpaRepository<Acl, UUID> {
    @Query(value = "Select * from Acl where requestor=:requestor and operation=:operation",nativeQuery = true)
    public Acl getConfiguration(String requestor, String operation);
}

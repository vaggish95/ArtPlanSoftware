package com.artplansoftware.secondtask.repository;

import com.artplansoftware.secondtask.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository <Role, Long> {
    Role findByName(String name);
}

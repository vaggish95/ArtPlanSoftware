package com.artplansoftware.secondtask.repository;

import com.artplansoftware.secondtask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    boolean existsByName(String name);
    User findByName (String name);

}

package com.artplansoftware.secondtask.repository;

import com.artplansoftware.secondtask.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long > {

    boolean existsByUserNameAndName (String username,  String animal_name);
    List<Animal> findByUserName (String username );
    Animal findByUserNameAndName (String username, String animal_name);
    void deleteByUserNameAndName(String username,  String animal_name);

}

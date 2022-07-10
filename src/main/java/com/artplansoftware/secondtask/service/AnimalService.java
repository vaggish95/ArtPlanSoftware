package com.artplansoftware.secondtask.service;

import com.artplansoftware.secondtask.entity.Animal;
import com.artplansoftware.secondtask.entity.User;
import com.artplansoftware.secondtask.exceptions.AnimalNotFoundException;
import com.artplansoftware.secondtask.exceptions.CreationOfExistingAnimalException;
import com.artplansoftware.secondtask.exceptions.EmptyAnimalsListException;
import com.artplansoftware.secondtask.repository.AnimalRepository;
import com.artplansoftware.secondtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.Principal;
import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;
    private  UserRepository userRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, UserRepository userRepository) {
        this.animalRepository = animalRepository;
        this.userRepository = userRepository;
    }

    public void addAnimal (Principal principal, Animal animal) {
        if ( !animalRepository.existsByUserNameAndName(principal.getName(), animal.getName())) {
            User user = userRepository.findByName(principal.getName());
            animal.setUser(user);
            animalRepository.save(animal);
        } else throw new CreationOfExistingAnimalException();
    }

    public Animal getOneAnimal (Principal principal, String name) {
        if (animalRepository.findByUserNameAndName (principal.getName(), name) == null)  {
            throw new AnimalNotFoundException();
        } else return animalRepository.findByUserNameAndName(principal.getName(), name);
    }

    public List<Animal> getAnimalsList (Principal principal) {
        if (animalRepository.findByUserName(principal.getName()).isEmpty()) {
            throw new EmptyAnimalsListException();
        } return animalRepository.findByUserName(principal.getName());
    }

    public void editAnimalName(Principal principal, String oldName, String newName) {
        Animal animal = animalRepository.findByUserNameAndName(principal.getName(), oldName);
        if (animal == null) {
                throw new AnimalNotFoundException();
            } else {
            animal.setName(newName);
            animalRepository.save(animal);
        }
    }

    @Transactional
    public void removeAnimal (String animal_Name, Principal principal) {
        if (animalRepository.existsByUserNameAndName(principal.getName(), animal_Name)) {
            animalRepository.deleteByUserNameAndName(principal.getName(), animal_Name);
        } else throw new AnimalNotFoundException();
    }
}

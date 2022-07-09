package com.artplansoftware.secondtask.controllers;

import com.artplansoftware.secondtask.entity.Animal;
import com.artplansoftware.secondtask.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsController {
    AnimalService animalService;

    @Autowired
    public AnimalsController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/add")
    public void addAnimal (@RequestBody Animal animal, Principal user) {
        animalService.addAnimal( user, animal );
    }

    @GetMapping("/info/{name}")
    public Animal getAnimal (@PathVariable (name= "name") String name, Principal user) {
        return animalService.getOneAnimal (user, name);
    }

    @GetMapping("/list")
    public List<Animal> getListOfAnimal (Principal user) {
      return animalService.getAnimalsList(user);
    }

    @PatchMapping ("/edit")
    public void editAnimal (String name, String new_name, Principal user) {
        animalService.editAnimal(user, name, new_name);
    }

    @DeleteMapping ("/delete/{name}")
    public void deleteAnimal ( @PathVariable (name= "name") String name, Principal user) {
        animalService.removeAnimal(name, user);
    }

}

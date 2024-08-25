package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
   private Map<Integer, Animal>  animals;

@PostConstruct
    public void loadAll(){

    System.out.println("postconstuct calıştqweqweıqe");
    this.animals= new HashMap<>();
    this.animals.put(1,new Animal(1,"maymun"));
    this.animals.put(2,new Animal(2,"ayi"));
}

@GetMapping
    public List<Animal> getAnimals(){

    System.out.println("animals get");
    return new ArrayList<>(animals.values());
}

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id ){

        if(id < 0){
            System.out.println("id cant less then zero"+ id);
            return null;

        } return this.animals.get(id);
    }

@PostMapping
    public void addAnimal(@RequestBody Animal animal){
    System.out.println("postconstuct calıştırıldı");
    this.animals.put(animal.getId(),animal);
}

@PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal newAnimal){

    this.animals.replace(id, newAnimal);
    return this.animals.get(id);
}

@DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id){
    this.animals.remove(id);
}


}

package kea.exam.kaeledyr.controllers;
import kea.exam.kaeledyr.entities.Animal;
import kea.exam.kaeledyr.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAnimals() {
        List<Animal> animals = animalService.getAnimals();
        return ResponseEntity.ok(animals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable int id) {
        Animal animal = animalService.getAnimal(id);
        return ResponseEntity.ok(animal);
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.createAnimal(animal);
        return ResponseEntity.ok(createdAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        Animal updatedAnimal = animalService.updateAnimal(id, animal);
        return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
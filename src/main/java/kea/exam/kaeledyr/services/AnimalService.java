package kea.exam.kaeledyr.services;

import kea.exam.kaeledyr.entities.Animal;
import kea.exam.kaeledyr.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal getAnimal(int id) {
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElse(null);
    }

    public Animal updateAnimal(int id, Animal animal) {
        Optional<Animal> existingAnimal = animalRepository.findById(id);
        if (existingAnimal.isPresent()) {
            Animal updatedAnimal = existingAnimal.get();
            updatedAnimal.setName(animal.getName());
            updatedAnimal.setAnimalType(animal.getAnimalType());
            updatedAnimal.setBirthdate(animal.getBirthdate());
            updatedAnimal.setStar(animal.isStar());
            updatedAnimal.setCutenessFactor(animal.getCutenessFactor());
            return animalRepository.save(updatedAnimal);
        } else {
            return null;
        }
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }
}

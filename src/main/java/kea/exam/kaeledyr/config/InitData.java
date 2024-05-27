package kea.exam.kaeledyr.config;

import kea.exam.kaeledyr.entities.Animal;
import kea.exam.kaeledyr.entities.AnimalType;
import kea.exam.kaeledyr.repositories.AnimalRepository;
import kea.exam.kaeledyr.repositories.AnimalTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final AnimalRepository animalRepository;
    private final AnimalTypeRepository animalTypeRepository;

    public InitData(AnimalRepository animalRepository, AnimalTypeRepository animalTypeRepository) {
        this.animalRepository = animalRepository;
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initAnimals();
    }

    private void initAnimals() {
        // Create some AnimalType instances
        AnimalType dogType = new AnimalType("Dog");
        AnimalType catType = new AnimalType("Cat");
        animalTypeRepository.save(dogType);
        animalTypeRepository.save(catType);

        // Create some Animal instances
        Animal dog = new Animal("Rex", dogType, "2010-05-20", true, 8.5);
        Animal cat = new Animal("Whiskers", catType, "2012-03-15", false, 7.0);

        // Save the Animal instances to the database
        animalRepository.save(dog);
        animalRepository.save(cat);
    }
}

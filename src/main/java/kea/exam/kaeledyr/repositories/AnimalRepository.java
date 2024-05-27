package kea.exam.kaeledyr.repositories;

import kea.exam.kaeledyr.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{
}

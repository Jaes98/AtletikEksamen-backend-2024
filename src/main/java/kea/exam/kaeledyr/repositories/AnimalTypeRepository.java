package kea.exam.kaeledyr.repositories;

import kea.exam.kaeledyr.entities.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Integer> {
}

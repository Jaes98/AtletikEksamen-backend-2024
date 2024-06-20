package kea.exam.atletikEksamen.config;

import kea.exam.atletikEksamen.entities.Discipline;
import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.entities.Result;
import kea.exam.atletikEksamen.repositories.DisciplineRepository;
import kea.exam.atletikEksamen.repositories.ParticipantRepository;
import kea.exam.atletikEksamen.repositories.ResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final ParticipantRepository participantRepository;
    private final DisciplineRepository disciplineRepository;
    private final ResultRepository resultRepository;

    public InitData(ParticipantRepository participantRepository, DisciplineRepository disciplineRepository, ResultRepository resultRepository) {
        this.participantRepository = participantRepository;
        this.disciplineRepository = disciplineRepository;
        this.resultRepository = resultRepository;
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
        Participant dog = new Participant("Rex", dogType, "2010-05-20", true, 8.5);
        Participant cat = new Participant("Whiskers", catType, "2012-03-15", false, 7.0);

        // Save the Animal instances to the database
        participantRepository.save(dog);
        participantRepository.save(cat);
    }
}

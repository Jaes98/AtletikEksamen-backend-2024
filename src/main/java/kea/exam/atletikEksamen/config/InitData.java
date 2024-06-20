package kea.exam.atletikEksamen.config;

import kea.exam.atletikEksamen.entities.Discipline;
import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.entities.Result;
import kea.exam.atletikEksamen.repositories.DisciplineRepository;
import kea.exam.atletikEksamen.repositories.ParticipantRepository;
import kea.exam.atletikEksamen.repositories.ResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        initSampleData();
    }

    private void initSampleData() {
        List<Discipline> disciplines = new ArrayList<>();
        List<Participant> participants = new ArrayList<>();
        List<Result> results = new ArrayList<>();

        // Create disciplines
        Discipline sprint = new Discipline("100m Sprint", "Track", new ArrayList<>(), new ArrayList<>());
        Discipline longJump = new Discipline("Long Jump", "Field", new ArrayList<>(), new ArrayList<>());
        Discipline javelinThrow = new Discipline("Javelin Throw", "Field", new ArrayList<>(), new ArrayList<>());
        Discipline poleVault = new Discipline("Pole Vault", "Field", new ArrayList<>(), new ArrayList<>());
        Discipline marathon = new Discipline("Marathon", "Track", new ArrayList<>(), new ArrayList<>());

        disciplines.add(sprint);
        disciplines.add(longJump);
        disciplines.add(javelinThrow);
        disciplines.add(poleVault);
        disciplines.add(marathon);

        // Create participants
        Participant mads = new Participant("Mads Nielsen", "Male", 25, "City Athletics Club", new ArrayList<>(), new ArrayList<>());
        Participant lise = new Participant("Lise Jensen", "Female", 22, "Town Track Team", new ArrayList<>(), new ArrayList<>());
        Participant anders = new Participant("Anders Pedersen", "Male", 30, "Suburb Running Club", new ArrayList<>(), new ArrayList<>());
        Participant ida = new Participant("Ida Hansen", "Female", 28, "County Marathoners", new ArrayList<>(), new ArrayList<>());
        Participant frederik = new Participant("Frederik Larsen", "Male", 23, "City Park Runners", new ArrayList<>(), new ArrayList<>());
        Participant mathilde = new Participant("Mathilde Christensen", "Female", 27, "National Throwers Association", new ArrayList<>(), new ArrayList<>());

        participants.add(mads);
        participants.add(lise);
        participants.add(anders);
        participants.add(ida);
        participants.add(frederik);
        participants.add(mathilde);

        // Associate participants with disciplines
        mads.getDisciplines().addAll(disciplines);
        lise.getDisciplines().addAll(List.of(sprint, poleVault, marathon));
        anders.getDisciplines().addAll(List.of(longJump, javelinThrow, marathon));
        ida.getDisciplines().addAll(List.of(sprint, marathon));
        frederik.getDisciplines().addAll(List.of(longJump, poleVault));
        mathilde.getDisciplines().addAll(List.of(javelinThrow, poleVault));

        // Create results and associate with participants
        results.add(new Result("Time", LocalDate.of(2023, 6, 10), sprint, mads));
        results.add(new Result("Distance", LocalDate.of(2023, 6, 15), longJump, lise));
        results.add(new Result("Distance", LocalDate.of(2023, 7, 5), javelinThrow, anders));
        results.add(new Result("Height", LocalDate.of(2023, 7, 20), poleVault, frederik));
        results.add(new Result("Time", LocalDate.of(2023, 8, 15), marathon, ida));

        results.add(new Result("Time", LocalDate.of(2023, 6, 10), sprint, mads));
        results.add(new Result("Height", LocalDate.of(2023, 7, 20), poleVault, frederik));
        results.add(new Result("Time", LocalDate.of(2023, 8, 15), marathon, ida));

        results.add(new Result("Distance", LocalDate.of(2023, 6, 15), longJump, lise));
        results.add(new Result("Distance", LocalDate.of(2023, 7, 5), javelinThrow, anders));
        results.add(new Result("Time", LocalDate.of(2023, 8, 15), marathon, ida));

        results.add(new Result("Time", LocalDate.of(2023, 6, 10), sprint, mads));
        results.add(new Result("Time", LocalDate.of(2023, 8, 15), marathon, ida));

        results.add(new Result("Distance", LocalDate.of(2023, 6, 15), longJump, lise));
        results.add(new Result("Height", LocalDate.of(2023, 7, 20), poleVault, frederik));

        results.add(new Result("Distance", LocalDate.of(2023, 7, 5), javelinThrow, anders));
        results.add(new Result("Height", LocalDate.of(2023, 7, 20), poleVault, frederik));

        // Save data to repositories
        disciplineRepository.saveAll(disciplines);
        participantRepository.saveAll(participants);
        resultRepository.saveAll(results);
    }
}

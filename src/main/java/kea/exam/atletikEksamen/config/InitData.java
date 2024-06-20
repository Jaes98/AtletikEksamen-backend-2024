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
        // Create some Discipline instances with empty lists
        Discipline sprint = new Discipline("100m Sprint", "Track", new ArrayList<>(), new ArrayList<>());
        Discipline longJump = new Discipline("Long Jump", "Field", new ArrayList<>(), new ArrayList<>());
        Discipline javelinThrow = new Discipline("Javelin Throw", "Field", new ArrayList<>(), new ArrayList<>());
        Discipline poleVault = new Discipline("Pole Vault", "Field", new ArrayList<>(), new ArrayList<>());
        Discipline marathon = new Discipline("Marathon", "Track", new ArrayList<>(), new ArrayList<>());

        // Save disciplines to the repository
        disciplineRepository.save(sprint);
        disciplineRepository.save(longJump);
        disciplineRepository.save(javelinThrow);
        disciplineRepository.save(poleVault);
        disciplineRepository.save(marathon);

        // Create some Participant instances with empty lists
        Participant mads = new Participant("Mads Nielsen", "Male", 25, "City Athletics Club", new ArrayList<>(), new ArrayList<>());
        Participant lise = new Participant("Lise Jensen", "Female", 22, "Town Track Team", new ArrayList<>(), new ArrayList<>());
        Participant anders = new Participant("Anders Pedersen", "Male", 30, "Suburb Running Club", new ArrayList<>(), new ArrayList<>());
        Participant ida = new Participant("Ida Hansen", "Female", 28, "County Marathoners", new ArrayList<>(), new ArrayList<>());
        Participant frederik = new Participant("Frederik Larsen", "Male", 23, "City Park Runners", new ArrayList<>(), new ArrayList<>());
        Participant mathilde = new Participant("Mathilde Christensen", "Female", 27, "National Throwers Association", new ArrayList<>(), new ArrayList<>());

        // Save the Participant instances to the database
        participantRepository.save(mads);
        participantRepository.save(lise);
        participantRepository.save(anders);
        participantRepository.save(ida);
        participantRepository.save(frederik);
        participantRepository.save(mathilde);

        // Associate Participants with Disciplines (many-to-many relationship)
        mads.getDisciplines().add(sprint);
        mads.getDisciplines().add(longJump);
        mads.getDisciplines().add(javelinThrow);
        mads.getDisciplines().add(poleVault);
        mads.getDisciplines().add(marathon);

        lise.getDisciplines().add(sprint);
        lise.getDisciplines().add(poleVault);
        lise.getDisciplines().add(marathon);

        anders.getDisciplines().add(longJump);
        anders.getDisciplines().add(javelinThrow);
        anders.getDisciplines().add(marathon);

        ida.getDisciplines().add(sprint);
        ida.getDisciplines().add(marathon);

        frederik.getDisciplines().add(longJump);
        frederik.getDisciplines().add(poleVault);

        mathilde.getDisciplines().add(javelinThrow);
        mathilde.getDisciplines().add(poleVault);

        // Save updated Participant instances to establish relationships
        participantRepository.save(mads);
        participantRepository.save(lise);
        participantRepository.save(anders);
        participantRepository.save(ida);
        participantRepository.save(frederik);
        participantRepository.save(mathilde);

        // Create some Result instances and associate with Participant and Discipline
        Result madsSprintResult = new Result("Time", LocalDate.of(2023, 6, 10), mads, sprint);
        Result madsLongJumpResult = new Result("Distance", LocalDate.of(2023, 6, 15), mads, longJump);
        Result madsJavelinThrowResult = new Result("Distance", LocalDate.of(2023, 7, 5), mads, javelinThrow);
        Result madsPoleVaultResult = new Result("Height", LocalDate.of(2023, 7, 20), mads, poleVault);
        Result madsMarathonResult = new Result("Time", LocalDate.of(2023, 8, 15), mads, marathon);

        Result liseSprintResult = new Result("Time", LocalDate.of(2023, 6, 10), lise, sprint);
        Result lisePoleVaultResult = new Result("Height", LocalDate.of(2023, 7, 20), lise, poleVault);
        Result liseMarathonResult = new Result("Time", LocalDate.of(2023, 8, 15), lise, marathon);

        Result andersLongJumpResult = new Result("Distance", LocalDate.of(2023, 6, 15), anders, longJump);
        Result andersJavelinThrowResult = new Result("Distance", LocalDate.of(2023, 7, 5), anders, javelinThrow);
        Result andersMarathonResult = new Result("Time", LocalDate.of(2023, 8, 15), anders, marathon);

        Result idaSprintResult = new Result("Time", LocalDate.of(2023, 6, 10), ida, sprint);
        Result idaMarathonResult = new Result("Time", LocalDate.of(2023, 8, 15), ida, marathon);

        Result frederikLongJumpResult = new Result("Distance", LocalDate.of(2023, 6, 15), frederik, longJump);
        Result frederikPoleVaultResult = new Result("Height", LocalDate.of(2023, 7, 20), frederik, poleVault);

        Result mathildeJavelinThrowResult = new Result("Distance", LocalDate.of(2023, 7, 5), mathilde, javelinThrow);
        Result mathildePoleVaultResult = new Result("Height", LocalDate.of(2023, 7, 20), mathilde, poleVault);

        // Save the Result instances to the database
        resultRepository.save(madsSprintResult);
        resultRepository.save(madsLongJumpResult);
        resultRepository.save(madsJavelinThrowResult);
        resultRepository.save(madsPoleVaultResult);
        resultRepository.save(madsMarathonResult);

        resultRepository.save(liseSprintResult);
        resultRepository.save(lisePoleVaultResult);
        resultRepository.save(liseMarathonResult);

        resultRepository.save(andersLongJumpResult);
        resultRepository.save(andersJavelinThrowResult);
        resultRepository.save(andersMarathonResult);

        resultRepository.save(idaSprintResult);
        resultRepository.save(idaMarathonResult);

        resultRepository.save(frederikLongJumpResult);
        resultRepository.save(frederikPoleVaultResult);

        resultRepository.save(mathildeJavelinThrowResult);
        resultRepository.save(mathildePoleVaultResult);
    }
}

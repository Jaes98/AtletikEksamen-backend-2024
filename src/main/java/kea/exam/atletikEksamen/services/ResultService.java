package kea.exam.atletikEksamen.services;

import kea.exam.atletikEksamen.entities.Discipline;
import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.entities.Result;
import kea.exam.atletikEksamen.repositories.DisciplineRepository;
import kea.exam.atletikEksamen.repositories.ParticipantRepository;
import kea.exam.atletikEksamen.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    private final ResultRepository resultRepository;
    private final ParticipantRepository participantRepository;
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository, ParticipantRepository participantRepository, DisciplineRepository disciplineRepository) {
        this.resultRepository = resultRepository;
        this.participantRepository = participantRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    public Result getResult(int id) {
        Optional<Result> result = resultRepository.findById(id);
        return result.orElse(null);
    }

    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    public Result updateResult(int id, Result result) {
        Optional<Result> existingResult = resultRepository.findById(id);
        if (existingResult.isPresent()) {
            Result updatedResult = existingResult.get();
            updatedResult.setResultType(result.getResultType());
            updatedResult.setDate(result.getDate());
//            updatedResult.setParticipant(result.getParticipant());
            updatedResult.setDiscipline(result.getDiscipline());
            return resultRepository.save(updatedResult);
        } else {
            return null;
        }
    }

    public void deleteResult(int id) {
        resultRepository.deleteById(id);
    }

    public List<Result> createMultipleResults(List<Result> results) {
        for (Result result : results) {
            Participant participant = participantRepository.findById(result.getParticipant().getId())
                    .orElseThrow(() -> new RuntimeException("Participant not found with id : " + result.getParticipant().getId()));
            Discipline discipline = disciplineRepository.findById(result.getDiscipline().getId())
                    .orElseThrow(() -> new RuntimeException("Discipline not found with id : " + result.getDiscipline().getId()));

            result.setParticipant(participant);
            result.setDiscipline(discipline);
        }

        return resultRepository.saveAll(results);
    }
}

package kea.exam.atletikEksamen.services;

import kea.exam.atletikEksamen.entities.Result;
import kea.exam.atletikEksamen.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
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
}

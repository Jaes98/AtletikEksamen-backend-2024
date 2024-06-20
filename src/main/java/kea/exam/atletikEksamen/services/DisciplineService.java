package kea.exam.atletikEksamen.services;

import kea.exam.atletikEksamen.entities.Discipline;
import kea.exam.atletikEksamen.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> getDisciplines() {
        return disciplineRepository.findAll();
    }

    public Discipline getDiscipline(int id) {
        Optional<Discipline> discipline = disciplineRepository.findById(id);
        return discipline.orElse(null);
    }

    public Discipline createDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public Discipline updateDiscipline(int id, Discipline discipline) {
        Optional<Discipline> existingDiscipline = disciplineRepository.findById(id);
        if (existingDiscipline.isPresent()) {
            Discipline updatedDiscipline = existingDiscipline.get();
            updatedDiscipline.setName(discipline.getName());
            updatedDiscipline.setResultType(discipline.getResultType());
            return disciplineRepository.save(updatedDiscipline);
        } else {
            return null;
        }
    }

    public void deleteDiscipline(int id) {
        disciplineRepository.deleteById(id);
    }
}

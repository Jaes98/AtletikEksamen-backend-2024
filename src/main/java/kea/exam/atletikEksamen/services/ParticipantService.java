package kea.exam.atletikEksamen.services;

import kea.exam.atletikEksamen.entities.Discipline;
import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.repositories.DisciplineRepository;
import kea.exam.atletikEksamen.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, DisciplineRepository disciplineRepository) {
        this.participantRepository = participantRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Optional<Participant> getParticipantById(int id) {
        return participantRepository.findById(id);
    }

    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(int id, Participant participant) {
        Optional<Participant> existingParticipantOptional = participantRepository.findById(id);
        if (existingParticipantOptional.isPresent()) {
            Participant existingParticipant = existingParticipantOptional.get();
            existingParticipant.setName(participant.getName());
            existingParticipant.setAge(participant.getAge());
            existingParticipant.setGender(participant.getGender());
            existingParticipant.setClub(participant.getClub());

            // Update disciplines
            List<Discipline> updatedDisciplines = new ArrayList<>();
            if (participant.getDisciplines() != null) {
                for (Discipline discipline : participant.getDisciplines()) {
                    Optional<Discipline> existingDisciplineOptional = disciplineRepository.findById(discipline.getId());
                    existingDisciplineOptional.ifPresent(updatedDisciplines::add);
                }
            }
            existingParticipant.setDisciplines(updatedDisciplines);

            return participantRepository.save(existingParticipant);
        } else {
            return null;
        }
    }


    public void deleteParticipant(int id) {
        participantRepository.deleteById(id);
    }
}

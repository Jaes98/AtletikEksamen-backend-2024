package kea.exam.atletikEksamen.services;

import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant getParticipant(int id) {
        Optional<Participant> participant = participantRepository.findById(id);
        return participant.orElse(null);
    }

    public Participant updateParticipant(int id, Participant participant) {
        Optional<Participant> existingParticipant = participantRepository.findById(id);
        if (existingParticipant.isPresent()) {
            Participant updatedParticipant = existingParticipant.get();
            updatedParticipant.setName(participant.getName());
            updatedParticipant.setAge(participant.getAge());
            updatedParticipant.setGender(participant.getGender());
            updatedParticipant.setClub(participant.getClub());
            return participantRepository.save(updatedParticipant);
        } else {
            return null;
        }
    }

    public void deleteParticipant(int id) {
        participantRepository.deleteById(id);
    }

    public List<Participant> getParticipants() {
        return participantRepository.findAll();
    }
}

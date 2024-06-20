package kea.exam.atletikEksamen.repositories;

import kea.exam.atletikEksamen.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>{
}

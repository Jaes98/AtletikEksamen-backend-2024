package kea.exam.atletikEksamen.controllers;
import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.services.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping
    public ResponseEntity<List<Participant>> getParticipants() {
        List<Participant> participants = participantService.getParticipants();
        return ResponseEntity.ok(participants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipant(@PathVariable int id) {
        Participant participant = participantService.getParticipant(id);
        return ResponseEntity.ok(participant);
    }

    @PostMapping
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant) {
        Participant createdParticipant = participantService.createParticipant(participant);
        return ResponseEntity.ok(createdParticipant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable int id, @RequestBody Participant participant) {
        Participant updatedParticipant = participantService.updateParticipant(id, participant);
        return ResponseEntity.ok(updatedParticipant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable int id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.noContent().build();
    }
}
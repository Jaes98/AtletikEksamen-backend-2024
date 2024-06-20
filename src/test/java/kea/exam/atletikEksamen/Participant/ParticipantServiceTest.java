package kea.exam.atletikEksamen.Participant;

import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.entities.Result;
import kea.exam.atletikEksamen.repositories.ParticipantRepository;
import kea.exam.atletikEksamen.services.ParticipantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ParticipantServiceTest {
    @Mock
    private ParticipantRepository participantRepository;

    @InjectMocks
    private ParticipantService participantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllParticipantsReturnsAllParticipants() {
        // Arrange
        Participant participant1 = new Participant();
        participant1.setResults(new ArrayList<>());
        participant1.setDisciplines(new ArrayList<>());
        Participant participant2 = new Participant();
        participant2.setDisciplines(new ArrayList<>());
        participant2.setResults(new ArrayList<>());
        List<Participant> mockParticipants = Arrays.asList(participant1, participant2);
        when(participantRepository.findAll()).thenReturn(mockParticipants);

        // Act
        List<Participant> participants = participantService.getAllParticipants();

        // Assert
        assertEquals(2, participants.size());
        verify(participantRepository, times(1)).findAll();
    }

    @Test
    void getParticipantByIdReturnsParticipantById() {
        // Arrange
        Participant participant = new Participant();
        when(participantRepository.findById(1)).thenReturn(Optional.of(participant));

        // Act
        Optional<Participant> result = participantService.getParticipantById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(participant, result.get());
        verify(participantRepository, times(1)).findById(1);
    }

    @Test
    void createParticipantSavesParticipant() {
    // Arrange
    Participant participantToSave = new Participant("John Doe", "Male", 30, "København Klub", new ArrayList<>(), new ArrayList<>());
    when(participantRepository.save(any(Participant.class))).thenReturn(participantToSave);

    // Act
    Participant savedParticipant = participantService.createParticipant(participantToSave);

    // Assert
    assertEquals(participantToSave.getName(), savedParticipant.getName());
    assertEquals(participantToSave.getGender(), savedParticipant.getGender());
    assertEquals(participantToSave.getAge(), savedParticipant.getAge());
    assertEquals(participantToSave.getClub(), savedParticipant.getClub());
    verify(participantRepository, times(1)).save(any(Participant.class));
}
    @Test
    void updateParticipantUpdatesParticipant() {
    // Arrange
    Participant participant = new Participant();
    when(participantRepository.findById(1)).thenReturn(Optional.of(participant));
    when(participantRepository.save(any(Participant.class))).thenReturn(participant);

    // Act
    Participant result = participantService.updateParticipant(1, participant);

    // Assert
    assertEquals(participant, result);
    verify(participantRepository, times(1)).findById(1);
    verify(participantRepository, times(1)).save(participant);
}

    @Test
    void deleteParticipantDeletesParticipant() {
    // Arrange
    Participant participant = new Participant();
    when(participantRepository.findById(1)).thenReturn(Optional.of(participant));

    // Act
    participantService.deleteParticipant(1);

    // Assert
    verify(participantRepository, times(1)).deleteById(1);
}
}

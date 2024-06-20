package kea.exam.atletikEksamen.Participant;

import kea.exam.atletikEksamen.controllers.ParticipantController;
import kea.exam.atletikEksamen.entities.Participant;
import kea.exam.atletikEksamen.services.ParticipantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ParticipantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ParticipantService participantService;

    @InjectMocks
    private ParticipantController participantController;

    @BeforeEach
    public void setUp() {
        // Initialize mocks and set up behavior
        MockitoAnnotations.openMocks(this);

        // Mock data setup using Mockito
        Participant mathilde = new Participant("Mathilde Christensen", "Female", 27, "National Throwers Association", null, null);
        when(participantService.getAllParticipants()).thenReturn(Collections.singletonList(mathilde));
    }

    @Test
    public void testShowAllParticipants() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/participants")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Mathilde Christensen"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(27))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender").value("Female"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].club").value("National Throwers Association"));
    }
}

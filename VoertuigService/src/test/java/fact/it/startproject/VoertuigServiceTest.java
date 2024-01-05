package fact.it.startproject;

import fact.it.startproject.dto.VoertuigResponse;
import fact.it.startproject.model.VoertuigModel;
import fact.it.startproject.repository.VoertuigRepository;
import fact.it.startproject.service.VoertuigService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;

@SpringBootTest
class VoertuigServiceTest {

    @Mock
    private VoertuigRepository voertuigRepository;

    @InjectMocks
    private VoertuigService voertuigService;

    @Test
    void testIsFree() {
        // Arrange
        VoertuigModel voertuig1 = new VoertuigModel();
        voertuig1.setVoertuigCode("1-ABC-123");
        voertuig1.setFree(true);

        VoertuigModel voertuig2 = new VoertuigModel();
        voertuig2.setVoertuigCode("2-AAA-111");
        voertuig2.setFree(false);

        List<String> voertuigCodes = Arrays.asList("1-ABC-123", "2-AAA-111");

        Mockito.when(voertuigRepository.findByVoertuigCodeIn(anyList()))
                .thenReturn(Arrays.asList(voertuig1, voertuig2));

        // Act
        List<VoertuigResponse> responses = voertuigService.isFree(voertuigCodes);

        // Assert
        assertEquals(2, responses.size());

        VoertuigResponse response1 = responses.get(0);
        assertEquals("1-ABC-123", response1.getVoertuigCode());
        assertEquals(true, response1.isFree());

        VoertuigResponse response2 = responses.get(1);
        assertEquals("2-AAA-111", response2.getVoertuigCode());
        assertEquals(false, response2.isFree());
    }
}

package fact.it.startproject;

import fact.it.startproject.dto.KlantenResponse;
import fact.it.startproject.model.KlantenModel;
import fact.it.startproject.repository.KlantenRepository;
import fact.it.startproject.service.KlantenService;
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
class KlantenServiceTest {

    @Mock
    private KlantenRepository klantenRepository;

    @InjectMocks
    private KlantenService klantenService;

    @Test
    void testCurrentLocation() {
        // Arrange
        KlantenModel klant1 = new KlantenModel();
        klant1.setId(1L); // Set the id
        klant1.setName("John Doe");
        klant1.setPhoneNumber("123456789");
        klant1.setCurrentLocation("City A");

        KlantenModel klant2 = new KlantenModel();
        klant2.setId(2L); // Set the id
        klant2.setName("Jane Doe");
        klant2.setPhoneNumber("987654321");
        klant2.setCurrentLocation("City B");

        List<String> phoneNumbers = Arrays.asList("123456789", "987654321");

        Mockito.when(klantenRepository.findByPhoneNumberIn(anyList()))
                .thenReturn(Arrays.asList(klant1, klant2));

        // Act
        List<KlantenResponse> responses = klantenService.currentLocation(phoneNumbers);

        // Assert
        assertEquals(2, responses.size());

        KlantenResponse response1 = responses.get(0);
        assertEquals("1", response1.getId());
        assertEquals("John Doe", response1.getName());
        assertEquals("123456789", response1.getPhoneNumber());
        assertEquals("City A", response1.getCurrentLocation());

        KlantenResponse response2 = responses.get(1);
        assertEquals("2", response2.getId());
        assertEquals("Jane Doe", response2.getName());
        assertEquals("987654321", response2.getPhoneNumber());
        assertEquals("City B", response2.getCurrentLocation());
    }
}

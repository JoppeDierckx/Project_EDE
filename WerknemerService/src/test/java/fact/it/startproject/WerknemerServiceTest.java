package fact.it.startproject;

import fact.it.startproject.dto.WerknemerResponse;
import fact.it.startproject.model.Werknemer;
import fact.it.startproject.repository.WerknemerRepository;
import fact.it.startproject.service.WerknemerService;
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
class WerknemerServiceTest {

    @Mock
    private WerknemerRepository werknemerRepository;

    @InjectMocks
    private WerknemerService werknemerService;

    @Test
    void testIsAvailable() {
        // Arrange
        Werknemer werknemer1 = new Werknemer(1L, "Bob", "0468326756", true);
        Werknemer werknemer2 = new Werknemer(2L, "Henry", "0468766756", false);

        List<String> phoneNumbers = Arrays.asList("0468326756", "0468766756");

        Mockito.when(werknemerRepository.findByPhoneNumberIn(anyList()))
                .thenReturn(Arrays.asList(werknemer1, werknemer2));

        // Act
        List<WerknemerResponse> responses = werknemerService.isAvailable(phoneNumbers);

        // Assert
        assertEquals(2, responses.size());

        WerknemerResponse response1 = responses.get(0);
        assertEquals("0468326756", response1.getPhoneNumber());
        assertEquals(true, response1.isAvailable());

        WerknemerResponse response2 = responses.get(1);
        assertEquals("0468766756", response2.getPhoneNumber());
        assertEquals(false, response2.isAvailable());
    }
}
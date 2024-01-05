package fact.it.tripservice;

import fact.it.tripservice.dto.TripRequest;
import fact.it.tripservice.dto.TripResponse;
import fact.it.tripservice.model.Trip;
import fact.it.tripservice.repository.TripRepository;
import fact.it.tripservice.service.TripService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TripServiceTest {

    @Mock
    private TripRepository tripRepository;

    @Mock
    private WebClient webClient;

    @InjectMocks
    private TripService tripService;

    @Test
    void testMakeTrip() {
        // Arrange
        TripRequest tripRequest = new TripRequest(/* provide necessary data */);

        // Mock behavior of the tripRepository
        when(tripRepository.save(any(Trip.class)))
                .thenAnswer(invocation -> {
                    Trip savedTrip = invocation.getArgument(0);
                    savedTrip.setTripNumber(UUID.randomUUID().toString());
                    return savedTrip;
                });

        // Act
        boolean tripResult = tripService.makeTrip(tripRequest);

        // Assert
        verify(tripRepository).save(any(Trip.class));
        assertEquals(true, tripResult);
    }

    @Test
    void testGetAllTrips() {
        // Arrange
        Trip trip1 = new Trip();
        trip1.setTripNumber(UUID.randomUUID().toString());

        Trip trip2 = new Trip();
        trip2.setTripNumber(UUID.randomUUID().toString());

        List<Trip> trips = Arrays.asList(trip1, trip2);

        // Mock behavior of the tripRepository
        when(tripRepository.findAll()).thenReturn(trips);

        // Act
        List<TripResponse> tripResponses = tripService.getAllTrips();

        // Assert
        assertEquals(2, tripResponses.size());
        assertEquals(trip1.getTripNumber(), tripResponses.get(0).getTripNumber());
        assertEquals(trip2.getTripNumber(), tripResponses.get(1).getTripNumber());
    }

    // Add more tests as needed
}

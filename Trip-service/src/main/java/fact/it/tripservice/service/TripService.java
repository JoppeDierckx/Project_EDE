package fact.it.tripservice.service;

import fact.it.tripservice.dto.TripRequest;
import fact.it.tripservice.dto.TripResponse;
import fact.it.tripservice.model.Trip;
import fact.it.tripservice.repository.TripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TripService {

    private final TripRepository tripRepository;
    private final WebClient webClient;

    public boolean makeTrip(TripRequest tripRequest){
        Trip trip = new Trip();
        trip.setTripNumber(UUID.randomUUID().toString());

        tripRepository.save(trip);
        return trip.getTripNumber() != null;
    };

    public List<TripResponse> getAllTrips() {
        List<Trip> trips = tripRepository.findAll();

        return trips.stream()
                .map(trip -> new TripResponse(
                        trip.getTripNumber()
                ))
                .collect(Collectors.toList());
    }
}

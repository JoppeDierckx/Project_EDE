package fact.it.startproject.service;

import fact.it.startproject.dto.TripRequest;
import fact.it.startproject.dto.TripResponse;
import fact.it.startproject.model.Trip;
import fact.it.startproject.repository.TripRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TripService {

    private final TripRepository tripRepository;

    @PostConstruct
    public void loadData() {
        if (tripRepository.count() == 0) {
            Trip trip1 = new Trip();
            trip1.setTripNumber(UUID.randomUUID().toString());

            Trip trip2 = new Trip();
            trip2.setTripNumber(UUID.randomUUID().toString());

            Trip trip3 = new Trip();
            trip3.setTripNumber(UUID.randomUUID().toString());

            tripRepository.save(trip1);
            tripRepository.save(trip2);
            tripRepository.save(trip3);
        }
    }

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

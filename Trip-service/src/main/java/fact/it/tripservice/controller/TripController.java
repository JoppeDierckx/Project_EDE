package fact.it.tripservice.controller;

import fact.it.tripservice.dto.TripRequest;
import fact.it.tripservice.dto.TripResponse;
import fact.it.tripservice.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String makeTrip(@RequestBody TripRequest tripRequest) {
        boolean result = tripService.makeTrip(tripRequest);
        return (result ? "Trip placed successfully" : "Trip order placement failed");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TripResponse> getAllProducts() {
        return tripService.getAllTrips();
    }
}

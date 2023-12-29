package fact.it.tripservice.repository;

import fact.it.tripservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}

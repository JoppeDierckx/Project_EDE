package fact.it.startproject.repository;

import fact.it.startproject.model.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    List<Werknemer> findByPhoneNumberIn(List<String> phoneNumber);

    Optional<Werknemer> findByPhoneNumber(String phoneNumber);
}

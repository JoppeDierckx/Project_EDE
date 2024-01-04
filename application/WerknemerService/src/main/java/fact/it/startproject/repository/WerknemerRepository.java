package fact.it.startproject.repository;

import fact.it.startproject.model.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    List<Werknemer> findByPhoneNumberIn(List<String> phoneNumber);
}

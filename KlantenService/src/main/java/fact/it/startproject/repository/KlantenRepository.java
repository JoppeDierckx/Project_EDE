package fact.it.startproject.repository;

import fact.it.startproject.model.KlantenModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KlantenRepository extends JpaRepository<KlantenModel, Long> {
    List<KlantenModel> findByPhoneNumberIn(List<String> phoneNumber);
}

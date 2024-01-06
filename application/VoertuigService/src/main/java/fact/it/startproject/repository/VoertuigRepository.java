package fact.it.startproject.repository;

import fact.it.startproject.model.VoertuigModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoertuigRepository extends JpaRepository<VoertuigModel, Long> {
    List<VoertuigModel> findByVoertuigCodeIn(List<String> voertuigCode);
    Optional<VoertuigModel> findByVoertuigCode(String voertuigCode);
}

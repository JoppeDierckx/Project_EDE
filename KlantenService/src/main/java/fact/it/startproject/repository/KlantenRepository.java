package fact.it.startproject.repository;

import fact.it.startproject.model.KlantenModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KlantenRepository extends MongoRepository<KlantenModel, String> {
    List<KlantenModel> findByPhoneNumberIn(List<String> phoneNumber);
}

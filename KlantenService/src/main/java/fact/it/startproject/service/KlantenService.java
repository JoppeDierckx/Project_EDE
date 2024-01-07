package fact.it.startproject.service;

import fact.it.startproject.dto.KlantenResponse;
import fact.it.startproject.model.KlantenModel;
import fact.it.startproject.repository.KlantenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KlantenService {

    private final KlantenRepository klantenRepository;

    @PostConstruct
    public void initializeSampleData() {
        // Initialize sample data for KlantenModel
        KlantenModel klant1 = new KlantenModel(1L, "John Doe", "123456789", "Location1");
        KlantenModel klant2 = new KlantenModel(2L, "Jane Doe", "987654321", "Location2");

        // Save the sample data to the MongoDB database
        klantenRepository.saveAll(List.of(klant1, klant2));
    }

    @Transactional(readOnly = true)
    public List<KlantenResponse> currentLocation(List<String> phoneNumber) {
        return klantenRepository.findByPhoneNumberIn(phoneNumber).stream()
                .map(klant -> KlantenResponse.builder()
                        .id(String.valueOf(klant.getId()))
                        .name(klant.getName())
                        .phoneNumber(klant.getPhoneNumber())
                        .currentLocation(klant.getCurrentLocation())
                        .build()
                )
                .collect(Collectors.toList());
    }
}

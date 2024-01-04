package fact.it.startproject.service;

import fact.it.startproject.dto.KlantenResponse;
import fact.it.startproject.model.KlantenModel;
import fact.it.startproject.repository.KlantenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KlantenService {

    private final KlantenRepository klantenRepository;

    public KlantenService(KlantenRepository klantenRepository) {
        this.klantenRepository = klantenRepository;
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

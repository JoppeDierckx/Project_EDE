package fact.it.startproject.service;

import fact.it.startproject.dto.WerknemerResponse;
import fact.it.startproject.model.Werknemer;
import fact.it.startproject.repository.WerknemerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WerknemerService {

    private final WerknemerRepository werknemerRepository;

    @PostConstruct
    public void loadData() {
        if(werknemerRepository.count() == 0) {
            Werknemer werknemer1 = new Werknemer();
            werknemer1.setAvailable(true);
            werknemer1.setName("Bob");
            werknemer1.setPhoneNumber("0468326756");

            Werknemer werknemer2 = new Werknemer();
            werknemer2.setAvailable(false);
            werknemer2.setName("Henry");
            werknemer2.setPhoneNumber("0468766756");

            werknemerRepository.save(werknemer1);
            werknemerRepository.save(werknemer2);

        }
    }

    @Transactional(readOnly = true)
    public List<WerknemerResponse> isAvailable(List<String> phoneNumber) {
        return werknemerRepository.findByPhoneNumberIn(phoneNumber).stream()
                .map(werknemer -> WerknemerResponse.builder()
                        .phoneNumber(werknemer.getPhoneNumber())
                        .isAvailable(werknemer.isAvailable())
                        .build()
                )
                .collect(Collectors.toList());
    }
}

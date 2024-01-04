package fact.it.startproject.service;

import fact.it.startproject.dto.VoertuigResponse;
import fact.it.startproject.model.VoertuigModel;
import fact.it.startproject.repository.VoertuigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoertuigService {

    private final VoertuigRepository voertuigRepository;

    @PostConstruct
    public void loadData() {
        if(voertuigRepository.count() == 0){
            VoertuigModel voertuig1 = new VoertuigModel();
            voertuig1.setVoertuigCode("1-ABC-123");
            voertuig1.setFree(true);

            VoertuigModel voertuig2 = new VoertuigModel();
            voertuig2.setVoertuigCode("2-AAA-111");
            voertuig2.setFree(false);

            voertuigRepository.save(voertuig1);
            voertuigRepository.save(voertuig2);
        }
    }

    @Transactional(readOnly = true)
    public List<VoertuigResponse> isFree(List<String> voertuigCode) {
        return voertuigRepository.findByVoertuigCodeIn(voertuigCode).stream()
                .map(voertuig -> VoertuigResponse.builder()
                        .voertuigCode(voertuig.getVoertuigCode())
                        .isFree(voertuig.isFree())
                        .build()
                )
                .collect(Collectors.toList());
    }
}

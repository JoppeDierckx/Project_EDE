package fact.it.startproject.controller;


import fact.it.startproject.dto.VoertuigRequest;
import fact.it.startproject.dto.VoertuigResponse;
import fact.it.startproject.service.VoertuigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voertuig")
@RequiredArgsConstructor
public class VoertuigController
{

    private final VoertuigService voertuigService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VoertuigResponse> isFree
            (@RequestParam List<String> voertuigCode) {
        return voertuigService.isFree(voertuigCode);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addVoertuig(@RequestBody VoertuigRequest voertuigRequest) {
        System.out.println("Service: " + voertuigRequest.toString());
        voertuigService.addVoertuig(voertuigRequest);
    }

    @DeleteMapping("/{voertuigCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVoertuig(@PathVariable String voertuigCode) {
        voertuigService.deleteVoertuig(voertuigCode);
    }
}

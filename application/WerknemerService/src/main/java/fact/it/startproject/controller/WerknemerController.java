package fact.it.startproject.controller;

import fact.it.startproject.dto.WerknemerResponse;
import fact.it.startproject.service.WerknemerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/werknemer")
@RequiredArgsConstructor
public class WerknemerController {

    private final WerknemerService werknemerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WerknemerResponse> isAvailable (@RequestParam List<String> phoneNumber) {
        return werknemerService.isAvailable(phoneNumber);
    }
}

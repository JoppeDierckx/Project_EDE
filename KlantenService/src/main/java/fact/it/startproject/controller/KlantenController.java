package fact.it.startproject.controller;

import fact.it.startproject.dto.KlantenResponse;
import fact.it.startproject.service.KlantenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/klant")
@RequiredArgsConstructor
public class KlantenController {

    private final KlantenService klantenService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<KlantenResponse> isAvailable(@RequestParam List<String> phoneNumber) {
        return klantenService.currentLocation(phoneNumber);
    }
}

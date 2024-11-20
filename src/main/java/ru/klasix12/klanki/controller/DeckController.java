package ru.klasix12.klanki.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.klasix12.klanki.dto.DeckDTO;
import ru.klasix12.klanki.service.DeckService;
import ru.klasix12.klanki.validation.groups.OnCreate;

@RestController
@RequestMapping("/api/deck")
@RequiredArgsConstructor
public class DeckController {
    private final DeckService deckService;

    @PostMapping
    public ResponseEntity<DeckDTO> create(
            @Validated(OnCreate.class)
            @RequestBody
            DeckDTO deckDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deckService.save(deckDTO));
    }
}

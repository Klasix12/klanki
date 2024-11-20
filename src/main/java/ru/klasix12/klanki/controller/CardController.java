package ru.klasix12.klanki.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.klasix12.klanki.dto.CardDTO;
import ru.klasix12.klanki.service.CardService;
import ru.klasix12.klanki.validation.groups.OnCreate;
import ru.klasix12.klanki.validation.groups.OnUpdate;

import java.util.List;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.findById(id));
    }

    @GetMapping("/deck/{deckId}")
    public ResponseEntity<List<CardDTO>> getAllByDeckId(@PathVariable long deckId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.findAllByDeckId(deckId));
    }

    @PostMapping
    public ResponseEntity<CardDTO> create(
            @Validated(OnCreate.class)
            @RequestBody
            CardDTO cardDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(cardDTO));
    }

    @PutMapping
    public ResponseEntity<CardDTO> update(
            @Validated(OnUpdate.class)
            @RequestBody
            CardDTO card) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.update(card));
    }
}

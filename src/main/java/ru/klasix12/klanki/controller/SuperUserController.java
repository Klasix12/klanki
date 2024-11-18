package ru.klasix12.klanki.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.model.SuperUserDTO;
import ru.klasix12.klanki.service.SuperUserService;

@RestController
@RequestMapping("/api/super-user")
@RequiredArgsConstructor
public class SuperUserController {

    private final SuperUserService superUserService;

    @PostMapping
    public ResponseEntity<SuperUserDTO> getUser(@RequestBody(required = true) SuperUser superUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(superUserService.create(superUser));
    }
}

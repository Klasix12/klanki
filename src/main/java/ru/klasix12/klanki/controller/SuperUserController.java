package ru.klasix12.klanki.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.klasix12.klanki.dto.SuperUserDTO;
import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.model.User;
import ru.klasix12.klanki.service.SuperUserService;
import ru.klasix12.klanki.validation.groups.OnCreate;
import ru.klasix12.klanki.validation.groups.OnUpdate;

import java.util.List;

@RestController
@RequestMapping("/api/super-user")
@RequiredArgsConstructor
public class SuperUserController {

    private final SuperUserService superUserService;

    @PostMapping
    public ResponseEntity<SuperUserDTO> create(
            @Validated(OnCreate.class)
            @RequestBody
            SuperUser superUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(superUserService.create(superUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuperUserDTO> update(
            @Validated(OnUpdate.class)
            @RequestBody
            SuperUser superUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(superUserService.update(superUser));
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<List<User>> getById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(superUserService.findUsersBySuperUserId(id));
    }
}

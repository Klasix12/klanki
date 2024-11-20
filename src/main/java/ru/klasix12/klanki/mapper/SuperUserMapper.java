package ru.klasix12.klanki.mapper;

import ru.klasix12.klanki.dto.SuperUserDTO;
import ru.klasix12.klanki.model.SuperUser;

public class SuperUserMapper {
    private SuperUserMapper() {
    }

    public static SuperUserDTO toDto(SuperUser superUser) {
        return SuperUserDTO.builder()
                .id(superUser.getId() == null ? 0 : superUser.getId())
                .username(superUser.getUsername())
                .email(superUser.getEmail())
                .build();
    }
}

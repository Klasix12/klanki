package ru.klasix12.klanki.mapper;

import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.model.SuperUserDTO;

public class SuperUserMapper {
    private SuperUserMapper() {}

    public static SuperUserDTO toDto(SuperUser superUser) {
        return SuperUserDTO.builder()
                .id(superUser.getId())
                .username(superUser.getUsername())
                .email(superUser.getEmail())
                .build();
    }
}

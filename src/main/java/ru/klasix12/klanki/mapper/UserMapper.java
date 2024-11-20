package ru.klasix12.klanki.mapper;

import ru.klasix12.klanki.dto.UserDTO;
import ru.klasix12.klanki.model.SuperUser;
import ru.klasix12.klanki.model.User;

public class UserMapper {
    private UserMapper() {
    }

    public static UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .superUserId(user.getSuperUser().getId())
                .build();
    }

    public static User toEntity(UserDTO userDTO, SuperUser superUser) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .superUser(superUser)
                .build();
    }
}

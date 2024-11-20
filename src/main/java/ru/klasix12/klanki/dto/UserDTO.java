package ru.klasix12.klanki.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import ru.klasix12.klanki.validation.groups.OnCreate;

@Data
@Builder
public class UserDTO {
    private long id;

    @NotNull(groups = OnCreate.class)
    private String username;

    @NotNull(groups = OnCreate.class)
    private Long superUserId;
}

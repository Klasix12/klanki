package ru.klasix12.klanki.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import ru.klasix12.klanki.validation.groups.OnCreate;

@Data
@Builder
public class DeckDTO {

    private long id;

    @NotNull(groups = OnCreate.class)
    private String name;

    @NotNull(groups = OnCreate.class)
    private long userId;
}

package ru.klasix12.klanki.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.klasix12.klanki.validation.groups.OnCreate;
import ru.klasix12.klanki.validation.groups.OnUpdate;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CardDTO {

    @NotNull(groups = OnUpdate.class)
    private long id;

    @NotNull(groups = OnCreate.class)
    private String front;

    @NotNull(groups = OnCreate.class)
    private String back;

    @NotNull(groups = {OnCreate.class, OnUpdate.class})
    private Long deckId;

    private Integer priority;
}

package ru.klasix12.klanki.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.klasix12.klanki.validation.groups.OnCreate;
import ru.klasix12.klanki.validation.groups.OnUpdate;

@Entity
@Table(name = "cards")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(groups = OnCreate.class)
    private String front;

    @NotNull(groups = OnUpdate.class)
    private String back;

    @ManyToOne
    private Deck deck;

    private Integer priority;
}

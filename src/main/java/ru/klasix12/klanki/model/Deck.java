package ru.klasix12.klanki.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.klasix12.klanki.validation.groups.OnCreate;

@Entity
@Table(name = "decks")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(groups = OnCreate.class)
    private String name;

    @ManyToOne
    private User user;
}

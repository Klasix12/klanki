package ru.klasix12.klanki.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "decks")
@Data
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private SuperUser superUser;
}

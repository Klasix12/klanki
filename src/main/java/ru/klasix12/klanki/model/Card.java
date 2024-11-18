package ru.klasix12.klanki.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cards")
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String front;
    private String back;

    @ManyToOne
    private Deck deck;
    private int priority;
}

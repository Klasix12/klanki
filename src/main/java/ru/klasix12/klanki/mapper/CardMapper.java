package ru.klasix12.klanki.mapper;

import ru.klasix12.klanki.dto.CardDTO;
import ru.klasix12.klanki.model.Card;
import ru.klasix12.klanki.model.Deck;

public class CardMapper {
    private CardMapper() {
    }

    public static CardDTO toDto(Card card) {
        return CardDTO.builder()
                .id(card.getId())
                .front(card.getFront())
                .back(card.getBack())
                .deckId(card.getDeck().getId())
                .priority(card.getPriority())
                .build();
    }

    public static Card toEntity(CardDTO cardDTO, Deck deck) {
        return Card.builder()
                .id(cardDTO.getId())
                .front(cardDTO.getFront())
                .back(cardDTO.getBack())
                .deck(deck)
                .priority(cardDTO.getPriority())
                .build();
    }
}

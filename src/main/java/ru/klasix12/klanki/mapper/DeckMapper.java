package ru.klasix12.klanki.mapper;


import ru.klasix12.klanki.dto.DeckDTO;
import ru.klasix12.klanki.model.Deck;
import ru.klasix12.klanki.model.User;

public class DeckMapper {
    private DeckMapper() {
    }

    public static DeckDTO toDto(Deck deck) {
        return DeckDTO.builder()
                .id(deck.getId())
                .name(deck.getName())
                .userId(deck.getUser().getId())
                .build();
    }

    public static Deck toEntity(DeckDTO deckDTO, User user) {
        return Deck.builder()
                .id(deckDTO.getId())
                .name(deckDTO.getName())
                .user(user)
                .build();
    }
}

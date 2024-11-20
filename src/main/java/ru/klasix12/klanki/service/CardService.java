package ru.klasix12.klanki.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.klasix12.klanki.dto.CardDTO;
import ru.klasix12.klanki.mapper.CardMapper;
import ru.klasix12.klanki.model.Card;
import ru.klasix12.klanki.model.Deck;
import ru.klasix12.klanki.repository.CardRepository;
import ru.klasix12.klanki.repository.DeckRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;

    public CardDTO findById(long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти карточку с id " + id));
        return CardMapper.toDto(card);
    }

    public List<CardDTO> findAllByDeckId(long deckId) {
        List<Card> cards = cardRepository.findAllByDeckId(deckId);
        return cards.stream().map(CardMapper::toDto).collect(Collectors.toList());
    }

    public CardDTO save(CardDTO card) {
        Deck deck = deckRepository.findById(card.getDeckId())
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти колоду с id " + card.getDeckId()));
        // задаем минимальный приоритет, чтобы карточка показывалась одной из первых
        card.setPriority(-1);
        return CardMapper.toDto(cardRepository.save(CardMapper.toEntity(card, deck)));
    }

    @Transactional
    public CardDTO update(CardDTO newCard) {
        Card card = cardRepository.findById(newCard.getId())
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти карточку с id " + newCard.getId()));
        Deck deck = deckRepository.findById(newCard.getDeckId())
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти колоду с id " + newCard.getId()));
        return CardMapper.toDto(cardRepository.save(Card.builder()
                .id(newCard.getId())
                .front(newCard.getFront() == null ? card.getFront() : newCard.getFront())
                .back(newCard.getBack() == null ? card.getBack() : newCard.getBack())
                .deck(deck)
                .priority(newCard.getPriority() == null ? card.getPriority() : newCard.getPriority())
                .build()));
    }
}

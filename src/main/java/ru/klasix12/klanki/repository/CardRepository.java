package ru.klasix12.klanki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.klasix12.klanki.model.Card;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("SELECT c FROM Card c WHERE c.deck.id = :deckId ORDER BY c.priority")
    List<Card> findAllByDeckId(@Param("deckId") long deckId);
}

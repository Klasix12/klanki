package ru.klasix12.klanki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.klasix12.klanki.model.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {
}

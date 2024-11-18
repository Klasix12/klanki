package ru.klasix12.klanki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.klasix12.klanki.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}

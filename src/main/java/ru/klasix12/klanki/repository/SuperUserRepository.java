package ru.klasix12.klanki.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.klasix12.klanki.model.SuperUser;

@Repository
public interface SuperUserRepository extends JpaRepository<SuperUser, Long> {
}

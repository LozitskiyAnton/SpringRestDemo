package ru.fox.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fox.service.models.Token;


import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token, Long> {
    Optional<Token> findOneByValue(String value);
}

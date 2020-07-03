package ru.fox.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fox.service.models.Token;

public interface TokensRepository extends JpaRepository<Token, Long> {
}

package ru.fox.service.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.fox.service.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersReposytory extends JpaRepository<User,Long> {
    List<User> findAllByFirstName(String firstName);

    Optional<User> findByLogin (String login);
}

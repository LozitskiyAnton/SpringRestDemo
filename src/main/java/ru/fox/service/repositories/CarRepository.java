package ru.fox.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fox.service.models.Car;

import java.util.List;

public interface CarRepository extends JpaRepository <Car, Long> {
    List<Car> findAllByOwner_FirstName(String firstNaneOwner);
}


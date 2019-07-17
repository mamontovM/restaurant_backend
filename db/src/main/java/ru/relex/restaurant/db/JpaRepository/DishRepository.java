package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}

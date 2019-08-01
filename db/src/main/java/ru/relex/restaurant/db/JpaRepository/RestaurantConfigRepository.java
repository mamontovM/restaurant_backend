package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.RestaurantConfig;

public interface RestaurantConfigRepository extends JpaRepository<RestaurantConfig, Integer> {
}

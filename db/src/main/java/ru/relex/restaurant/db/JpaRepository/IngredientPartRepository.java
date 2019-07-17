package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.IngredientPart;

public interface IngredientPartRepository extends JpaRepository<IngredientPart, Integer> {
}

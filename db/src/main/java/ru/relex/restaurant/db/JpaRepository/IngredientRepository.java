package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
  Ingredient findByName(String name);

  Page<Ingredient> findIngredientsByNameLikeIgnoreCase(String like, Pageable sort);
}

package ru.relex.restaurant.db.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.relex.restaurant.db.entity.DishIngredient;
import ru.relex.restaurant.db.entity.DishIngredientId;

import java.util.List;

public interface DishIngredientRepository extends JpaRepository<DishIngredient, DishIngredientId> {

  List<DishIngredient> findDishIngredientsByIngredient_Id(Integer id);
}

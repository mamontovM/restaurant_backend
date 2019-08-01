package ru.relex.restaurant.service;

import ru.relex.restaurant.service.DTO.DishIngredientDto;
import ru.relex.restaurant.service.DTO.DishIngredientIdDto;

import java.util.List;

public interface IDishIngredientService {
  void createDishIngredient(DishIngredientDto dto);

  void deleteDishIngredient(DishIngredientIdDto id);

  boolean isUsedInDish(Integer ingredientId);
}

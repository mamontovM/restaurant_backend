package ru.relex.restaurant.service;

import ru.relex.restaurant.service.DTO.DishIngredientDto;

import java.util.List;

public interface IDishIngredientService {
  void createDishIngredient(DishIngredientDto dto);

  List<DishIngredientDto> listDishIngredients();
}

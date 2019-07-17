package ru.relex.restaurant.service;


import ru.relex.restaurant.service.DTO.IngredientDto;


import java.util.List;


public interface IIngredientService {
  void createIngredient(IngredientDto ingredientDto);

  List<IngredientDto> listIngredients();

  void updateIngredient(IngredientDto ingredientDto);

  void deleteIngredient(Integer id);
}

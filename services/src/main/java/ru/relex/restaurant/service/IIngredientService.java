package ru.relex.restaurant.service;


import ru.relex.restaurant.service.DTO.*;


import java.util.List;


public interface IIngredientService {
  void createIngredient(IngredientDto ingredientDto);

  IngredientsWithTotalCountDto listIngredients(int pageIndex, int pageSize, String sortDirection, String sortedBy);

  List<IngredientDto> listIngredientsNoPagination();

  void updateIngredient(IngredientDto ingredientDto);

  void deleteIngredient(Integer id);

  List<MissingIngredientDto> getMissingIngredients(List<DishDto> dishesInMenu);

  boolean checkIngredientNameUnique(String name);
}

package ru.relex.restaurant.service;


import ru.relex.restaurant.service.DTO.IngredientPartFullDto;
import ru.relex.restaurant.service.DTO.OrderDishDto;

import java.util.List;


public interface IIngredientPartService {

  void createIngredientPart(IngredientPartFullDto dto);

  void deleteIngredientPart(int id);

  boolean reduceAmountOfIngredient(Integer ingrId, Double delta);

  Double summaryAmountOfIngredient(Integer ingrId);

  Double summaryVolumeOfAllIngredients();
  boolean debetIngredients(List<OrderDishDto> dishes);
}

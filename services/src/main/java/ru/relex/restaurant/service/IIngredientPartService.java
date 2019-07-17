package ru.relex.restaurant.service;


import ru.relex.restaurant.service.DTO.IngredientPartDto;
import ru.relex.restaurant.service.DTO.IngredientPartFullDto;

import java.util.List;

public interface IIngredientPartService {
  List<IngredientPartDto> listIngredientParts();//List<IngredientPartDto> listIngredientParts(IngredientDto dto)

  IngredientPartDto findOneById(int id);

  void createIngredientPart(IngredientPartFullDto dto);

  void updateIngredientPart(IngredientPartDto dto);

  void deleteIngredientPart(int id);
}

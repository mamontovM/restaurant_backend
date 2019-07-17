package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.Ingredient;
import ru.relex.restaurant.service.DTO.IngredientForDishDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IIngredientForDishMapper {
  Ingredient fromDto(IngredientForDishDto dto);

  IngredientForDishDto toDto(Ingredient ingredient);

  List<Ingredient> fromDto(List<IngredientForDishDto> dtos);

  List<IngredientForDishDto> toDto(List<Ingredient> ingredients);
}

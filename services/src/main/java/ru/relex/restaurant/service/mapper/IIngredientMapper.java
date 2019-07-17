package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.Ingredient;
import ru.relex.restaurant.service.DTO.IngredientDto;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IIngredientMapper {
  Ingredient fromDto(IngredientDto dto);

  IngredientDto toDto(Ingredient ingredient);

  List<Ingredient> fromDto(List<IngredientDto> dtos);

  List<IngredientDto> toDto(List<Ingredient> ingredients);
}

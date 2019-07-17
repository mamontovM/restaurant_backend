package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.DishIngredient;
import ru.relex.restaurant.service.DTO.DishIngredientDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishIngredientMapper {
  DishIngredientDto toDto(DishIngredient dish);

  DishIngredient fromDto(DishIngredientDto dto);

  List<DishIngredientDto> toDto(List<DishIngredient> dishes);

  List<DishIngredient> fromDto(List<DishIngredientDto> dtos);
}

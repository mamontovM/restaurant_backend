package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.IngredientPart;
import ru.relex.restaurant.service.DTO.IngredientPartFullDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IIngredientPartFullMapper {
  IngredientPart fromDto(IngredientPartFullDto dto);

  IngredientPartFullDto toDto(IngredientPart ingredient);

  List<IngredientPart> fromDto(List<IngredientPartFullDto> dtos);

  List<IngredientPartFullDto> toDto(List<IngredientPart> ingredients);
}

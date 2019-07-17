package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.IngredientPart;
import ru.relex.restaurant.service.DTO.IngredientPartDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IIngredientPartMapper {
  IngredientPart fromDto(IngredientPartDto dto);

  IngredientPartDto toDto(IngredientPart ingredient);

  List<IngredientPart> fromDto(List<IngredientPartDto> dtos);

  List<IngredientPartDto> toDto(List<IngredientPart> ingredients);
}

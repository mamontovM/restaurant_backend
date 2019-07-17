package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.Dish;
import ru.relex.restaurant.service.DTO.DishDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishMapper {
  DishDto toDto(Dish dish);

  Dish fromDto(DishDto dto);

  List<DishDto> toDto(List<Dish> dishes);

  List<Dish> fromDto(List<DishDto> dtos);
}

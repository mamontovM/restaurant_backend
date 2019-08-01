package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.RestaurantConfig;
import ru.relex.restaurant.service.DTO.RestaurantConfigDto;

// import java.util.List;

@Mapper(componentModel = "spring")
public interface IRestaurantConfigMapper {
  RestaurantConfigDto toDto(RestaurantConfig config);

  RestaurantConfig fromDto(RestaurantConfigDto dto);
//
//  List<RestaurantConfigDto> toDto(List<RestaurantConfig> configs);
//
//  List<RestaurantConfig> fromDto(List<RestaurantConfigDto> dtos);
}

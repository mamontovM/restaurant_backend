package ru.relex.restaurant.service;

import ru.relex.restaurant.service.DTO.RestaurantConfigDto;

public interface IRestaurantConfigService {
  RestaurantConfigDto getConfig();

  void changeConfig(RestaurantConfigDto edited);
}

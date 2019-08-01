package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.RestaurantConfigRepository;
import ru.relex.restaurant.service.DTO.RestaurantConfigDto;
import ru.relex.restaurant.service.IRestaurantConfigService;
import ru.relex.restaurant.service.mapper.IRestaurantConfigMapper;

@Service
public class RestaurantConfigService implements IRestaurantConfigService {
  private final IRestaurantConfigMapper mapper;
  private final RestaurantConfigRepository repository;

  public RestaurantConfigService(IRestaurantConfigMapper mapper, RestaurantConfigRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Override
  public RestaurantConfigDto getConfig() {
    return mapper.toDto(repository.findById(1).orElse(null));
  }

  @Override
  public void changeConfig(RestaurantConfigDto edited) {
    repository.save(mapper.fromDto(edited));
  }
}

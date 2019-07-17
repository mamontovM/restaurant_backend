package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.DishRepository;

import ru.relex.restaurant.service.DTO.DishDto;
import ru.relex.restaurant.service.IDishService;
import ru.relex.restaurant.service.mapper.IDishMapper;

import java.util.List;

@Service
public class DishService implements IDishService {
  private final DishRepository dishRepository;
  private final IDishMapper mapper;

  public DishService(DishRepository dishRepository, IDishMapper mapper) {
    this.dishRepository = dishRepository;
    this.mapper = mapper;
  }

  @Override
  public void createDish(DishDto dto) {
    dishRepository.save(mapper.fromDto(dto));
  }

  @Override
  public List<DishDto> listDishesInMenu() {
    return null;
  }

  @Override
  public List<DishDto> listDishesAllTime() {
    return mapper.toDto(dishRepository.findAll());
  }

  @Override
  public void updateDish(DishDto dish) {

  }

  @Override
  public void deleteDish(int id) {

  }
}

package ru.relex.restaurant.service;


import ru.relex.restaurant.service.DTO.DishDto;

import java.util.List;

public interface IDishService {
  void createDish(DishDto dish);

  List<DishDto> listDishesInMenu();

  List<DishDto> listDishesAllTime();

  void updateDish(DishDto dish);

  void deleteDish(int id);
}

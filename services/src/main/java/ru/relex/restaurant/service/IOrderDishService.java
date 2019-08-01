package ru.relex.restaurant.service;

import ru.relex.restaurant.db.entity.OrderDish;
import ru.relex.restaurant.service.DTO.DishDto;
import ru.relex.restaurant.service.DTO.OrderDishDto;

import java.util.List;

public interface IOrderDishService {
    public boolean insert(List<OrderDishDto> orderDishesDto);

  boolean isOrderedDish(DishDto dish);
}

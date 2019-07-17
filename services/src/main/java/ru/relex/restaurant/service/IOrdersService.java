package ru.relex.restaurant.service;

import ru.relex.restaurant.service.DTO.OrdersDto;

import java.util.List;

public interface IOrdersService {
  public List<OrdersDto> getAll();

  public OrdersDto getById(int id);

  public OrdersDto update(OrdersDto ordersDto);

  public boolean insert(OrdersDto ordersDto);
}

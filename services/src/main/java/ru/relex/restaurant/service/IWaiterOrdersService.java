package ru.relex.restaurant.service;

import ru.relex.restaurant.db.entity.WaiterOrders;
import ru.relex.restaurant.service.DTO.WaiterOrdersDto;

import java.util.List;

public interface IWaiterOrdersService {
  public List<WaiterOrdersDto> getAll();

  public WaiterOrdersDto getById(int id);

  public boolean insert(WaiterOrdersDto waiterOrders);

  public WaiterOrdersDto update(WaiterOrdersDto waiterOrders);
}

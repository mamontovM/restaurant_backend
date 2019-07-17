package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.OrdersRepository;
import ru.relex.restaurant.db.entity.Orders;
import ru.relex.restaurant.service.DTO.OrdersDto;
import ru.relex.restaurant.service.IOrdersService;
import ru.relex.restaurant.service.mapper.IOrdersMapper;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements IOrdersService {
  private final OrdersRepository ordersRepository;
  private final IOrdersMapper ordersMapper;

  public OrdersService(OrdersRepository ordersRepository, IOrdersMapper ordersMapper) {
    this.ordersRepository = ordersRepository;
    this.ordersMapper = ordersMapper;
  }

  @Override
  public List<OrdersDto> getAll() {
    List<Orders> ordersList = ordersRepository.findAll();
    return ordersMapper.toDto(ordersList);
  }

  @Override
  public OrdersDto getById(int id) {
    Optional<Orders> orders = ordersRepository.findById(id);
    if (orders.isEmpty()) {
      return null;
    }
    return ordersMapper.toDto(orders.get());
  }

  @Override
  public OrdersDto update(OrdersDto ordersDto) {
    Orders orders = ordersMapper.fromDto(ordersDto);
    Optional<Orders> newOrders = ordersRepository.findById(orders.getId());
    if (newOrders.isEmpty()) {
      return null;
    }
    Orders updatedOrders = ordersRepository.save(newOrders.get());
    return ordersMapper.toDto(updatedOrders);
  }

  @Override
  public boolean insert(OrdersDto ordersDto) {
    Orders orders = ordersMapper.fromDto(ordersDto);
    if (orders == null) {
      return false;
    }
    ordersRepository.save(orders);
    return true;
  }
}

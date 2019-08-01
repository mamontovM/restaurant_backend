package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.OrdersRepository;
import ru.relex.restaurant.db.JpaRepository.UsersRepository;
import ru.relex.restaurant.db.entity.History;
import ru.relex.restaurant.db.entity.Orders;
import ru.relex.restaurant.db.entity.Users;
import ru.relex.restaurant.service.DTO.OrdersDto;
import ru.relex.restaurant.service.IOrdersService;
import ru.relex.restaurant.service.mapper.IOrdersMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements IOrdersService {
  private final OrdersRepository ordersRepository;
  private final IOrdersMapper ordersMapper;
  private final UsersRepository usersRepository;

  public OrdersService(OrdersRepository ordersRepository, IOrdersMapper ordersMapper, UsersRepository usersRepository) {
    this.ordersRepository = ordersRepository;
    this.ordersMapper = ordersMapper;
    this.usersRepository = usersRepository;
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
    Orders updatedOrders = ordersRepository.save(ordersMapper.fromDto(ordersDto));
    return ordersMapper.toDto(updatedOrders);
  }

  @Override
  public OrdersDto insert(OrdersDto ordersDto) {
    Orders orders = ordersMapper.fromDto(ordersDto);
    if (orders == null) {
      return null;
    }
    Orders createdOrder = ordersRepository.save(orders);
    return ordersMapper.toDto(createdOrder);
  }

  @Override
  public List<OrdersDto> getAllById(int id) {
    List<Orders> ordersList = ordersRepository.findAll();
    List<Orders> ordersOfUser = new ArrayList<>();
    Users currentUser = usersRepository.findById(id).get();
    boolean isGiven;
    boolean isAdd;
    for (Orders curOrd : ordersList) {
      isGiven = false;
      isAdd = false;
      for (History curHis : curOrd.getHistoryList()) {
        if (currentUser.getRoleId() == 3 && curHis.getStatusId() == 6) {
          isGiven = true;
          break;
        } else if (currentUser.getRoleId() == 2 && curHis.getStatusId() == 5) {
          isGiven = true;
          break;
        } else if (curHis.getUserId() == id) {
          isAdd = true;
        }
      }
      if (isAdd&&!isGiven){
        ordersOfUser.add(curOrd);
      }
    }
    return ordersMapper.toDto(ordersOfUser);
  }

}

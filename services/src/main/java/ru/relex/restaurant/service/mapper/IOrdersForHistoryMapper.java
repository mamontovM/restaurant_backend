package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;

import ru.relex.restaurant.db.entity.Orders;
import ru.relex.restaurant.service.DTO.OrdersForHistoryDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrdersForHistoryMapper {

  Orders fromDto(OrdersForHistoryDto ordersDto);

  OrdersForHistoryDto toDto(Orders orders);

  List<Orders> fromDto(List<OrdersForHistoryDto> ordersDtoList);

  List<OrdersForHistoryDto> toDto(List<Orders> ordersList);
}

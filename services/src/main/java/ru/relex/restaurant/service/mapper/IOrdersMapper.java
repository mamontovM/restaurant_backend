package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.Orders;
import ru.relex.restaurant.service.DTO.OrdersDto;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IOrdersMapper {

  Orders fromDto(OrdersDto ordersDto);

  OrdersDto toDto(Orders orders);

  List<Orders> fromDto(List<OrdersDto> ordersDtoList);

  List<OrdersDto> toDto(List<Orders> ordersList);
}

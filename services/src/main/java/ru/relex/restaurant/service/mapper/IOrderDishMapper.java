package ru.relex.restaurant.service.mapper;


import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.OrderDish;
import ru.relex.restaurant.db.entity.Orders;
import ru.relex.restaurant.service.DTO.OrderDishDto;
import ru.relex.restaurant.service.DTO.OrdersDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderDishMapper {

    OrderDish fromDto(OrderDishDto orderDishDto);

    OrderDishDto toDto(OrderDish orderDish);

    List<OrderDish> fromDto(List<OrderDishDto> orderDishesDto);

    List<OrderDishDto> toDto(List<OrderDish> orderDishes);

}

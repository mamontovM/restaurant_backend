package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.WaiterOrders;
import ru.relex.restaurant.service.DTO.WaiterOrdersDto;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IWaiterOrdersMapper {

  WaiterOrders fromDto(WaiterOrdersDto waiterOrdersDto);

  WaiterOrdersDto toDto(WaiterOrders waiterOrders);

  List<WaiterOrders> fromDto(List<WaiterOrdersDto> waiterOrdersDtoList);

  List<WaiterOrdersDto> toDto(List<WaiterOrders> waiterOrdersList);
}

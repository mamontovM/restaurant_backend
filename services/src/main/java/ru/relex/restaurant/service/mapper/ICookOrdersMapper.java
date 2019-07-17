package ru.relex.restaurant.service.mapper;

import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.CookOrders;
import ru.relex.restaurant.service.DTO.CookOrdersDto;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ICookOrdersMapper {

  CookOrders fromDto(CookOrdersDto cookOrdersDto);

  CookOrdersDto toDto(CookOrders cookOrders);

  List<CookOrders> fromDto(List<CookOrdersDto> cookOrdersDtoList);

  List<CookOrdersDto> toDto(List<CookOrders> cookOrdersl);
}

package ru.relex.restaurant.service.mapper;


import org.mapstruct.Mapper;
import ru.relex.restaurant.db.entity.History;
import ru.relex.restaurant.service.DTO.HistoryDto;
import ru.relex.restaurant.service.DTO.HistoryOrderDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IHistoryOrderMapper {

  HistoryOrderDto toDto(History history);

  History fromDto(HistoryOrderDto historyOrderDto);


  List<HistoryOrderDto> toDto(List<History> historyList);


  List<History> fromDto(List<HistoryOrderDto> historyOrderDtos);
}

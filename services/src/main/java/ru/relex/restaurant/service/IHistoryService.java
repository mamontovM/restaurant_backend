package ru.relex.restaurant.service;

import ru.relex.restaurant.service.DTO.HistoryDto;
import ru.relex.restaurant.service.DTO.StatisticDto;

import java.util.Date;
import java.util.List;

public interface IHistoryService {
  public HistoryDto nextStatus(HistoryDto historyDto);

  List<HistoryDto> getAll(Date from, Date to);

  StatisticDto getStatistic(Date from, Date to);
}

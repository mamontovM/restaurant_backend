package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.restaurant.db.JpaRepository.HistoryRepository;
import ru.relex.restaurant.db.entity.History;
import ru.relex.restaurant.service.DTO.*;
import ru.relex.restaurant.service.IHistoryService;
import ru.relex.restaurant.service.IOrdersService;
import ru.relex.restaurant.service.mapper.IHistoryMapper;
import ru.relex.restaurant.service.utils.StatusEnum;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService implements IHistoryService {
  private final IHistoryMapper historyMapper;
  private final HistoryRepository historyRepository;
  private final IOrdersService ordersService;

  public HistoryService(IHistoryMapper historyMapper, HistoryRepository historyRepository, IOrdersService ordersService) {
    this.historyMapper = historyMapper;
    this.historyRepository = historyRepository;
    this.ordersService = ordersService;
  }

  @Override
  @Transactional
  public HistoryDto nextStatus(HistoryDto historyDto) {
    History historyForSave = historyMapper.fromDto(historyDto);
    historyForSave.setTime(new Date());
    History savedHistory = historyRepository.save(historyForSave);
    if (historyDto.getCook_id() != null) {
      historyForSave.setUserId(historyDto.getCook_id());
      historyForSave.setTime(new Date());
      historyForSave.setStatusId(StatusEnum.CookAssigned.getStatusId());
      savedHistory = historyRepository.save(historyForSave);
    }
    return historyMapper.toDto(savedHistory);
  }

  @Override
  public List<HistoryDto> getAll(Date from, Date to) {
    return historyMapper.toDto(historyRepository.findAllByTimeBetweenAndStatusIdIs(from, to, 5));
  }

  /**
   * возвращает выручку, использванные ингредиенты и количество проданных блюд за указанный промежуток времени
   *
   * @param from
   * @param to
   * @return
   */
  @Override
  public StatisticDto getStatistic(Date from, Date to) {
    StatisticDto result = new StatisticDto();
    Map<String, Integer> soldDishes = new HashMap<>();
    Map<String, Double> usedIngredients = new HashMap<>();
    Double revenue = 0.0;
    List<HistoryDto> history = getAll(from, to);
    for (HistoryDto oneHistory : history) {

      for (OrderDishDto oneOrderConsist : oneHistory.getOrder().getConsist()) {
        // подсчет выручки и количества проданных блюд
        if (soldDishes.containsKey(oneOrderConsist.getDish().getName())) {
          Integer newDishesCount = soldDishes.get(oneOrderConsist.getDish().getName()) + oneOrderConsist.getCount();
          soldDishes.put(oneOrderConsist.getDish().getName(), newDishesCount);
          revenue += oneOrderConsist.getCount() * oneOrderConsist.getDish().getCost();
        } else {
          soldDishes.put(oneOrderConsist.getDish().getName(), oneOrderConsist.getCount());
          revenue += oneOrderConsist.getCount() * oneOrderConsist.getDish().getCost();
        }

        // подсчитываем потраченные ингредиенты
        for (DishIngredientDto oneDishConsist : oneOrderConsist.getDish().getConsist()) {
          if (usedIngredients.containsKey(oneDishConsist.getIngredient().getName())) {
            Double newIngredientCount = usedIngredients.get(oneDishConsist.getIngredient().getName()) +
                oneOrderConsist.getCount() * oneDishConsist.getValue();
            usedIngredients.put(oneDishConsist.getIngredient().getName(), newIngredientCount);
          } else {
            usedIngredients.put(oneDishConsist.getIngredient().getName(), oneOrderConsist.getCount() * oneDishConsist.getValue());
          }
        }

      }
    }
    result.setRevenue(revenue);
    result.setSoldDishes(soldDishes);
    result.setUsedIngredients(usedIngredients);
    return result;
  }
}

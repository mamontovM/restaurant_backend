package ru.relex.restaurant.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.DishRepository;

import ru.relex.restaurant.service.DTO.DishDto;
import ru.relex.restaurant.service.DTO.DishesWithTotalCountDto;
import ru.relex.restaurant.service.IDishService;
import ru.relex.restaurant.service.IIngredientPartService;
import ru.relex.restaurant.service.IOrderDishService;
import ru.relex.restaurant.service.mapper.IDishMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DishService implements IDishService {
  private final DishRepository dishRepository;
  private final IDishMapper dishMapper;
  private final IIngredientPartService ingredientPartService;
  private final IOrderDishService orderDishService;

  public DishService(DishRepository dishRepository, IDishMapper mapper,
                     IIngredientPartService ingredientPartService, IOrderDishService orderDishService) {
    this.dishRepository = dishRepository;
    this.dishMapper = mapper;
    this.ingredientPartService = ingredientPartService;
    this.orderDishService = orderDishService;
  }

  @Override
  public void createDish(DishDto dto) {
    if (dto.getCost() > 0) {
      dishRepository.save(dishMapper.fromDto(dto));
    }
  }

  @Override
  public void updateDish(DishDto dish) {
    if (orderDishService.isOrderedDish(dish)) {
      // такое блюдо уже заказывали - у него нельзя менять состав и цену
      DishDto oldDish = dishMapper.toDto(dishRepository.findById(dish.getId()).orElse(null));
      dish.setConsist(oldDish.getConsist());
      dish.setCost(oldDish.getCost());
    }
    if (dish.getCost() > 0) {
      dishRepository.save(dishMapper.fromDto(dish));
    }
  }

  @Override
  public List<DishDto> listDishesInMenu() {
    List<DishDto> dishesInMenu = dishMapper.toDto(dishRepository.findAllDishesInMenu());

    for (int i = 0; i < dishesInMenu.size(); i++) {
      dishesInMenu.get(i).setMaxCount(calculateMaxDishCount(dishesInMenu.get(i)));
    }
    return dishesInMenu;
  }

  /**
   * вычисляет максимально возможное количество блюда
   *
   * @param dish
   * @return
   */
  private Integer calculateMaxDishCount(DishDto dish) {
    ArrayList<Integer> ingredientMaxDish = new ArrayList<>();
    for (int j = 0; j < dish.getConsist().size(); j++) {
      Double temp = ingredientPartService.summaryAmountOfIngredient(dish.getConsist().get(j).getIngredient().getId())
          / dish.getConsist().get(j).getValue();
      ingredientMaxDish.add(temp.intValue());
    }
    if (dish.getConsist().size() == 0) {
      ingredientMaxDish.add(0);
    }
    return Collections.min(ingredientMaxDish);
  }

  @Override
  public DishesWithTotalCountDto listDishesAllTime(int pageIndex, int pageSize, String sortDirection,
                                                   String sortedBy, String filter) {
    DishesWithTotalCountDto result = new DishesWithTotalCountDto();
    Pageable sortAndPaginator = PageRequest.of(pageIndex, pageSize, Sort.Direction.fromString(sortDirection), sortedBy);
    List<DishDto> dishes = dishMapper.toDto(
        dishRepository.findDishesByNameLikeIgnoreCase("%" + filter + "%", sortAndPaginator).getContent());
    for (DishDto dish : dishes) {
      dish.setEditable(!orderDishService.isOrderedDish(dish));
    }
    result.setItems(dishes);
    result.setTotalCount(
        dishRepository.findDishesByNameLikeIgnoreCase("%" + filter + "%", sortAndPaginator).getTotalElements());
    return result;
  }

  @Override
  public void deleteUnsoldDish(Integer id) {
    DishDto dish = dishMapper.toDto(dishRepository.findById(id).orElse(null));

    if (!orderDishService.isOrderedDish(dish)) {
      // не было в заказах таких блюд
      dishRepository.deleteById(id);
    }
  }

}

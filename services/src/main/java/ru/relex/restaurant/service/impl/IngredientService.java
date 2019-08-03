package ru.relex.restaurant.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.IngredientRepository;
import ru.relex.restaurant.service.DTO.*;
import ru.relex.restaurant.service.IIngredientService;
import ru.relex.restaurant.service.mapper.IIngredientMapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class IngredientService implements IIngredientService {
  public IngredientService(final IngredientRepository repository, final IIngredientMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;

  }

  private final IngredientRepository repository;
  private final IIngredientMapper mapper;

  private static final Integer DISHES_IN_RESERVE = 10; // количество блюд в запасе, для рассчета недостающих ингредиентов
  private static final Integer MIN_EXPIRATION_DATE = 7; // минимальный запас срока годности в днях


  @Override
  public void createIngredient(IngredientDto ingredientDto) {
    repository.save(mapper.fromDto(ingredientDto));
  }

  @Override
  public IngredientsWithTotalCountDto listIngredients(int pageIndex, int pageSize, String sortDirection, String sortedBy) {
    IngredientsWithTotalCountDto result = new IngredientsWithTotalCountDto();

    Pageable sortAndPaginator = PageRequest.of(pageIndex, pageSize, Sort.Direction.fromString(sortDirection), sortedBy);

    result.setItems(mapper.toDto(repository.findAll(sortAndPaginator).getContent()));
    result.setTotalCount(repository.count());

    return result;
  }

  @Override
  public List<IngredientDto> listIngredientsNoPagination() {
    return mapper.toDto(repository.findAll());
  }

  @Override
  public void updateIngredient(IngredientDto ingredientDto) {
    repository.save(mapper.fromDto(ingredientDto));
  }

  @Override
  public void deleteIngredient(Integer id) {
    repository.deleteById(id);
  }


  /**
   * Возвращает список всех недостающих ингредиентов
   *
   * @param dishesInMenu
   * @return
   */
  @Override
  public List<MissingIngredientDto> getMissingIngredients(List<DishDto> dishesInMenu) {

    List<IngredientDto> allIngredietns = mapper.toDto(repository.findAll());
    List<MissingIngredientDto> missingIngredietns = new ArrayList<>();
    Double maxCountOfIngredientInDishes = 0.0;


    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, MIN_EXPIRATION_DATE - 1);

    for (int i = 0; i < allIngredietns.size(); i++) {
      maxCountOfIngredientInDishes = 0.0;

      // получаем максимальное количество ингредиента в блюде из меню
      for (int j = 0; j < dishesInMenu.size(); j++) {
        int ingredientNumberInOrder = -1;
        // ищем есть ли в составе блюда ингредиент и запоминаем порядковый номер в ingredientNumberInOrder
        for (int k = 0; k < dishesInMenu.get(j).getConsist().size(); k++) {
          if (dishesInMenu.get(j).getConsist().get(k).getId().getIngredientId() == allIngredietns.get(i).getId()) {
            ingredientNumberInOrder = k;
            break;
          }
        }
        if (ingredientNumberInOrder >= 0) {
          if (maxCountOfIngredientInDishes < dishesInMenu.get(j).getConsist().get(ingredientNumberInOrder).getValue()) {
            maxCountOfIngredientInDishes = dishesInMenu.get(j).getConsist().get(ingredientNumberInOrder).getValue();
          }
        }
      }

      Double summaryCountIngredientInAllParties = 0.0;
      // посчитать суммарное количество ингредиента по всем партиям где срок годности больше или равен недели
      for (int j = 0; j < allIngredietns.get(i).getParts().size(); j++) {
        if (allIngredietns.get(i).getParts().get(j).getExpirationDate().after(calendar.getTime()) ||
            allIngredietns.get(i).getParts().get(j).getExpirationDate().equals(calendar.getTime())) {
          summaryCountIngredientInAllParties += allIngredietns.get(i).getParts().get(j).getValue();
        }
      }
      if (summaryCountIngredientInAllParties < DISHES_IN_RESERVE * maxCountOfIngredientInDishes) {
        MissingIngredientDto temp = new MissingIngredientDto();
        temp.setId(allIngredietns.get(i).getId());
        temp.setName(allIngredietns.get(i).getName());
        temp.setMeasure(allIngredietns.get(i).getMeasure());
        temp.setAmount(summaryCountIngredientInAllParties);
        temp.setNeedAmount(DISHES_IN_RESERVE * maxCountOfIngredientInDishes);
        missingIngredietns.add(temp);
      }
    }
    return missingIngredietns;
  }

  @Override
  public boolean checkIngredientNameUnique(String name) {
    IngredientDto found = mapper.toDto(repository.findByName(name));
    if (found == null) {
      return true;
    } else {
      return false;
    }
  }
}

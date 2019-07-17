package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.DishIngredientRepository;
import ru.relex.restaurant.service.DTO.DishDto;
import ru.relex.restaurant.service.DTO.DishIngredientDto;
import ru.relex.restaurant.service.IDishIngredientService;
import ru.relex.restaurant.service.IDishService;
import ru.relex.restaurant.service.mapper.IDishIngredientMapper;

import java.util.List;

@Service
public class DishIngredientService implements IDishIngredientService {
  private final IDishIngredientMapper mapper;
  private final DishIngredientRepository repository;

  public DishIngredientService(IDishIngredientMapper mapper, DishIngredientRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Override
  public void createDishIngredient(DishIngredientDto dto) {
    repository.save(mapper.fromDto(dto));
  }

  @Override
  public List<DishIngredientDto> listDishIngredients() {
    return mapper.toDto(repository.findAll());//mapper.toDto(repository.findAll());
  }
}

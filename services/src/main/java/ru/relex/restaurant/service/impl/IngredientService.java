package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.IngredientRepository;
import ru.relex.restaurant.service.IIngredientService;
import ru.relex.restaurant.service.DTO.IngredientDto;
import ru.relex.restaurant.service.mapper.IIngredientMapper;

import java.util.List;

@Service
public class IngredientService implements IIngredientService {
  public IngredientService(final IngredientRepository repository, final IIngredientMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  private final IngredientRepository repository;
  private final IIngredientMapper mapper;


  @Override
  public void createIngredient(IngredientDto ingredientDto) {
    repository.save(mapper.fromDto(ingredientDto));
  }

  @Override
  public List<IngredientDto> listIngredients() {
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
}

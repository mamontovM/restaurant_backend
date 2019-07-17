package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.db.JpaRepository.IngredientPartRepository;
import ru.relex.restaurant.db.entity.IngredientPart;
import ru.relex.restaurant.service.DTO.IngredientPartFullDto;
import ru.relex.restaurant.service.IIngredientPartService;
import ru.relex.restaurant.service.DTO.IngredientPartDto;
import ru.relex.restaurant.service.mapper.IIngredientPartFullMapper;
import ru.relex.restaurant.service.mapper.IIngredientPartMapper;

import java.util.List;

@Service
public class IngredientPartService implements IIngredientPartService {
  private final IIngredientPartMapper mapper;
  private final IIngredientPartFullMapper mapperFull;
  private final IngredientPartRepository repository;

  public IngredientPartService(IIngredientPartMapper mapper, IngredientPartRepository repository, IIngredientPartFullMapper mapperFull) {
    this.mapper = mapper;
    this.repository = repository;
    this.mapperFull = mapperFull;
  }

  @Override
  public List<IngredientPartDto> listIngredientParts() {
    return mapper.toDto(repository.findAll());
  }

  @Override
  public IngredientPartDto findOneById(int id) {
    return mapper.toDto(repository.findById(id).orElse(null));
  }

  @Override
  public void createIngredientPart(IngredientPartFullDto dto) {
    repository.save(mapperFull.fromDto(dto));
  }

  @Override
  public void updateIngredientPart(IngredientPartDto dto) {

  }

  @Override
  public void deleteIngredientPart(int id) {
    repository.deleteById(id);
  }
}

package ru.relex.restaurant.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.relex.restaurant.service.DTO.IngredientPartFullDto;
import ru.relex.restaurant.service.IIngredientPartService;
import ru.relex.restaurant.service.DTO.IngredientDto;
import ru.relex.restaurant.service.DTO.IngredientPartDto;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredientparts",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IngredientPartController {
  private final IIngredientPartService ingredientPartService;

  public IngredientPartController(IIngredientPartService ingredientPartService) {
    this.ingredientPartService = ingredientPartService;
  }

  @GetMapping
  public List<IngredientPartDto> listIngredientParts() {
    return ingredientPartService.listIngredientParts();
  }

  @GetMapping("/{id}")
  public IngredientPartDto oneIngredientPart(@PathVariable("id") int id) {
    return ingredientPartService.findOneById(id);
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  private void createPart(@RequestBody IngredientPartFullDto dto) {
    ingredientPartService.createIngredientPart(dto);
  }

  @DeleteMapping("/{id}")
  public void deletePart(@PathVariable("id") int id) {
    ingredientPartService.deleteIngredientPart(id);
  }
}

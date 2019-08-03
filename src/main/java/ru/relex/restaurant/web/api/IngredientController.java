package ru.relex.restaurant.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.relex.restaurant.service.DTO.IngredientsWithTotalCountDto;
import ru.relex.restaurant.service.DTO.MissingIngredientDto;
import ru.relex.restaurant.service.IDishIngredientService;
import ru.relex.restaurant.service.IDishService;
import ru.relex.restaurant.service.IIngredientService;
import ru.relex.restaurant.service.DTO.IngredientDto;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(path = "/ingredients",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class IngredientController {
  private final IIngredientService ingredientService;
  private final IDishService dishService;
  private final IDishIngredientService dishIngredientService;

  public IngredientController(IIngredientService ingredientService, IDishService dishService, IDishIngredientService dishIngredientService) {
    this.ingredientService = ingredientService;
    this.dishService = dishService;
    this.dishIngredientService = dishIngredientService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @RolesAllowed({"KEEPER"})
  public void createIngredient(@RequestBody IngredientDto ingredientDto) {
    ingredientService.createIngredient(ingredientDto);
  }

  @GetMapping("/isUsed/{id}")
  public boolean isIngredientUsedInDish(@PathVariable("id") Integer ingredientId) {
    return dishIngredientService.isUsedInDish(ingredientId);
  }

  @GetMapping("/nopage")
  public List<IngredientDto> listIngredientsNoPagination() {
    return ingredientService.listIngredientsNoPagination();
  }


  @GetMapping
  public IngredientsWithTotalCountDto listIngredients(
      @RequestParam(name = "pageIndex", required = false, defaultValue = "0") int pageIndex,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
      @RequestParam(name = "sortedBy", required = false, defaultValue = "id") String sortedBy,
      @RequestParam(name = "sortDir", required = false, defaultValue = "asc") String sortDir,
      @RequestParam(name = "filter", required = false, defaultValue = "") String filter) {
    return ingredientService.listIngredients(pageIndex, pageSize, sortDir, sortedBy, filter);
  }

  @GetMapping("/missing")
  @RolesAllowed({"KEEPER", "ADMIN", "COOKER"})
  public List<MissingIngredientDto> listMissingIngredients() {
    return ingredientService.getMissingIngredients(dishService.listDishesInMenu());
  }

  @GetMapping("/check")
  @RolesAllowed({"KEEPER"})
  public boolean checkIngredientNameUnique(@RequestParam(name = "name") String name) {
    return ingredientService.checkIngredientNameUnique(name);
  }

  @DeleteMapping("/{id}")
  @RolesAllowed({"KEEPER"})
  public void removeIngredient(@PathVariable("id") int id) {
    ingredientService.deleteIngredient(id);
  }


}

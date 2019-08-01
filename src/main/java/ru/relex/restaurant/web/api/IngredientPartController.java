package ru.relex.restaurant.web.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.relex.restaurant.service.DTO.IngredientPartFullDto;
import ru.relex.restaurant.service.DTO.OrderDishDto;
import ru.relex.restaurant.service.IIngredientPartService;

import javax.annotation.security.RolesAllowed;
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

  @PostMapping
  @RolesAllowed({"KEEPER"})
  public void createPart(@RequestBody IngredientPartFullDto dto) {
    ingredientPartService.createIngredientPart(dto);
  }

  @PutMapping("/reduce") // вроде можно удалить
  public boolean reduceAmountOfIngredient(@RequestParam(name = "ingredientId", required = true) Integer ingredientId,
                                          @RequestParam(name = "delta", required = true) Double delta) {
    return ingredientPartService.reduceAmountOfIngredient(ingredientId, delta);
  }

  @PutMapping("/debit")
  @RolesAllowed({"WAITER", "COOKER"})
  public boolean debitIngredietns(@RequestBody List<OrderDishDto> dishes) {
    return ingredientPartService.debetIngredients(dishes);
  }

  @GetMapping("/summaryVolume")
  @RolesAllowed({"ADMIN", "KEEPER", "COOKER"})
  public Double summaryVolumeOfAllIngredients() {
    return ingredientPartService.summaryVolumeOfAllIngredients();
  }


  @DeleteMapping("/{id}")
  @RolesAllowed({"KEEPER"})
  public void deletePart(@PathVariable("id") int id) {
    ingredientPartService.deleteIngredientPart(id);
  }

  @GetMapping("/summary/{id}")
  public Double summaryAmountOfIngredient(@PathVariable("id") int id) {
    return ingredientPartService.summaryAmountOfIngredient(id);
  }
}

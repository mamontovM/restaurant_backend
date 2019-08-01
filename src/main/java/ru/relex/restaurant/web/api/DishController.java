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
import org.springframework.web.bind.annotation.PutMapping;
import ru.relex.restaurant.service.DTO.DishDto;
import ru.relex.restaurant.service.DTO.DishIngredientDto;
import ru.relex.restaurant.service.DTO.DishIngredientIdDto;
import ru.relex.restaurant.service.DTO.DishesWithTotalCountDto;
import ru.relex.restaurant.service.IDishIngredientService;
import ru.relex.restaurant.service.IDishService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(path = "/dishes",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DishController {
  private final IDishService dishService;
  private final IDishIngredientService dishIngredientService;

  public DishController(IDishService dishService, IDishIngredientService dishIngredientService) {
    this.dishService = dishService;
    this.dishIngredientService = dishIngredientService;
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @RolesAllowed({"ADMIN"})
  public void createDish(@RequestBody DishDto dishDto) {
    dishService.createDish(dishDto);
  }

  @PutMapping
  @RolesAllowed({"ADMIN"})
  public void updateDish(@RequestBody DishDto dishDto) {
    dishService.updateDish(dishDto);
  }

  @DeleteMapping("/{dishId}")
  @RolesAllowed({"ADMIN"})
  public void deleteUnsoldDish(@PathVariable("dishId") Integer dishId) {
    dishService.deleteUnsoldDish(dishId);
  }

  @GetMapping
  @RolesAllowed({"ADMIN"})
  public DishesWithTotalCountDto listDishesAllTime(
      @RequestParam(name = "pageIndex", required = false, defaultValue = "0") int pageIndex,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
      @RequestParam(name = "sortedBy", required = false, defaultValue = "id") String sortedBy,
      @RequestParam(name = "sortDir", required = false, defaultValue = "asc") String sortDir,
      @RequestParam(name = "filter", required = false, defaultValue = "") String filter

  ) {
    return dishService.listDishesAllTime(pageIndex, pageSize, sortDir, sortedBy, filter);
  }

  @GetMapping("/inmenu")
  @RolesAllowed({"WAITER"})
  public List<DishDto> listDishesInMenu() {
    return dishService.listDishesInMenu();
  }

  @PostMapping("/consist")
  @ResponseStatus(HttpStatus.CREATED)
  @RolesAllowed({"ADMIN"})
  public void createDishIngredient(@RequestBody DishIngredientDto dishIngDto) {
    dishIngredientService.createDishIngredient(dishIngDto);
  }

  @DeleteMapping("/consist/{dishId}/{ingId}")
  @RolesAllowed({"ADMIN"})
  public void deleteDishIngredient(@PathVariable("dishId") int dishId, @PathVariable("ingId") int ingId) {
    DishIngredientIdDto tempId = new DishIngredientIdDto();
    tempId.setDishId(dishId);
    tempId.setIngredientId(ingId);
    dishIngredientService.deleteDishIngredient(tempId);
  }
}

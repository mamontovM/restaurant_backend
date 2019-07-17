package ru.relex.restaurant.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.restaurant.service.DTO.DishDto;
import ru.relex.restaurant.service.DTO.DishIngredientDto;
import ru.relex.restaurant.service.IDishIngredientService;
import ru.relex.restaurant.service.IDishService;

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
    public void createIngredient(@RequestBody DishDto dishDto) {
        dishService.createDish(dishDto);
    }

    @GetMapping
    public List<DishDto> listDishesAllTime() {
        return dishService.listDishesAllTime();
    }

    @GetMapping("/d")
    public List<DishIngredientDto> listDishIngr() {
        return dishIngredientService.listDishIngredients();
    }


}

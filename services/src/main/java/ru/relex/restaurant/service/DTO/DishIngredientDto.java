package ru.relex.restaurant.service.DTO;

import ru.relex.restaurant.db.entity.DishIngredientId;

public class DishIngredientDto {

  private DishIngredientId id;
  private Double value;
  private IngredientForDishDto ingredient;


  public DishIngredientDto() {
  }

  public DishIngredientId getId() {
    return id;
  }

  public void setId(DishIngredientId id) {
    this.id = id;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public IngredientForDishDto getIngredient() {
    return ingredient;
  }

  public void setIngredient(IngredientForDishDto ingredient) {
    this.ingredient = ingredient;
  }
}

package ru.relex.restaurant.service.DTO;

import ru.relex.restaurant.db.entity.DishIngredientId;

public class DishIngredientDto {
  // private Integer id;
  private DishIngredientId id;
  private Double value;
  private IngredientDto ingredient;


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

  public IngredientDto getIngredient() {
    return ingredient;
  }

  public void setIngredient(IngredientDto ingredient) {
    this.ingredient = ingredient;
  }
}

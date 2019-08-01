package ru.relex.restaurant.service.DTO;

public class DishIngredientIdDto {
  private Integer dishId;
  private Integer ingredientId;

  public DishIngredientIdDto() {
  }

  public Integer getDishId() {
    return dishId;
  }

  public void setDishId(Integer dishId) {
    this.dishId = dishId;
  }

  public Integer getIngredientId() {
    return ingredientId;
  }

  public void setIngredientId(Integer ingredientId) {
    this.ingredientId = ingredientId;
  }
}

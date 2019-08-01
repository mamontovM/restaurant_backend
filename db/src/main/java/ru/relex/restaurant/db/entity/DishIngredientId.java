package ru.relex.restaurant.db.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DishIngredientId implements Serializable {
  //default serial version id, required for serializable classes.
  private static final long serialVersionUID = 1L;

  @Column(name = "dish_id")
  private Integer dishId;

  @Column(name = "ingredient_id")
  private Integer ingredientId;

  public DishIngredientId() {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DishIngredientId that = (DishIngredientId) o;
    return Objects.equals(dishId, that.dishId) &&
        Objects.equals(ingredientId, that.ingredientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dishId, ingredientId);
  }

  @Override
  public String toString() {
    return "DishIngredientId{" +
        "dishId=" + dishId +
        ", ingredienetId=" + ingredientId +
        '}';
  }
}

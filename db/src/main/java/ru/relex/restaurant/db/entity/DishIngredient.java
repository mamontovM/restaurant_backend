package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dish_ingredient")
@Embeddable
public class DishIngredient implements Serializable {
  //    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dish_ingredient_seq")
//    @SequenceGenerator(name = "dish_ingredient_seq", sequenceName = "dish_ingredient_id_seq", allocationSize = 1)
//    private Integer id;
  @EmbeddedId
  private DishIngredientId id;

  private Double value;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dish_id", insertable = false, updatable = false) //
  private Dish dish;

  @ManyToOne
  @JoinColumn(name = "ingredient_id", insertable = false, updatable = false) // , insertable = false, updatable = false
  private Ingredient ingredient;

  public DishIngredient() {
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

  public Ingredient getIngredient() {
  return ingredient;
}

  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DishIngredient that = (DishIngredient) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, value);
  }
}

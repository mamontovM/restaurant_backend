package ru.relex.restaurant.db.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dishes")
public class Dish {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dishes_seq")
  @SequenceGenerator(name = "dishes_seq", sequenceName = "dishes_id_seq", allocationSize = 1)
  private Integer id;
  private String name;

  @Column(updatable = false)
  private Double cost;
  private String type;
  private Boolean ismenu;

  @ElementCollection
  @CollectionTable(name = "dish_ingredient", joinColumns = @JoinColumn(name = "dish_id"))
  @Column(name = "value")
  private List<Double> values = new ArrayList<>();

  public List<Double> getValues() {
    return values;
  }

  public void setValues(List<Double> values) {
    this.values = values;
  }
//    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<DishIngredient> dishIngredient3 = new ArrayList<>();


  @ManyToMany()
  @JoinTable(name = "dish_ingredient",
      joinColumns = @JoinColumn(name = "dish_id"),
      inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
  private List<Ingredient> ingredients;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Dish() {
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getIsmenu() {
    return ismenu;
  }

  public void setIsmenu(Boolean ismenu) {
    this.ismenu = ismenu;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dish dish = (Dish) o;
    return Objects.equals(id, dish.id) &&
        Objects.equals(name, dish.name) &&
        Objects.equals(cost, dish.cost) &&
        Objects.equals(type, dish.type) &&
        Objects.equals(ismenu, dish.ismenu) &&
        Objects.equals(values, dish.values) &&
        Objects.equals(ingredients, dish.ingredients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cost, type, ismenu, values, ingredients);
  }
}

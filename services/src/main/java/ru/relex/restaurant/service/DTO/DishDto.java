package ru.relex.restaurant.service.DTO;

import java.util.List;

public class DishDto {

  private Integer id;
  private String name;
  private Double cost;
  private String type;
  private Boolean ismenu;
  private List<Double> values;
  private List<IngredientForDishDto> ingredients;

  public DishDto() {
  }

  public List<Double> getValues() {
    return values;
  }

  public void setValues(List<Double> values) {
    this.values = values;
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

  public List<IngredientForDishDto> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<IngredientForDishDto> ingredients) {
    this.ingredients = ingredients;
  }
}

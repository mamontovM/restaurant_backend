package ru.relex.restaurant.service.DTO;

import java.util.List;

public class IngredientForDishDto {
  private Integer id;
  private String name;
  private String measure;

  public IngredientForDishDto() {
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

  public String getMeasure() {
    return measure;
  }

  public void setMeasure(String measure) {
    this.measure = measure;
  }

}

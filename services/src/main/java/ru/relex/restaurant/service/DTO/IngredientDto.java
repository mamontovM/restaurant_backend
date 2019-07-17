package ru.relex.restaurant.service.DTO;


import java.util.List;


public class IngredientDto {
  private Integer id;
  private String name;
  private String measure;
  private List<IngredientPartDto> parts;

  public IngredientDto() {
  }

  public IngredientDto(Integer id, String name, String measure, List<IngredientPartDto> parts) {
    this.id = id;
    this.name = name;
    this.measure = measure;
    this.parts = parts;
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

  public List<IngredientPartDto> getParts() {
    return parts;
  }

  public void setParts(List<IngredientPartDto> parts) {
    this.parts = parts;
  }
}

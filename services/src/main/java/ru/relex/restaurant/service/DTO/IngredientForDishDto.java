package ru.relex.restaurant.service.DTO;


public class IngredientForDishDto {
  private Integer id;
  private String name;
  private String measure;
  private Double volumePerUnit;

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

  public Double getVolumePerUnit() {
    return volumePerUnit;
  }

  public void setVolumePerUnit(Double volumePerUnit) {
    this.volumePerUnit = volumePerUnit;
  }
}
